package org.antczak.bitbucket2gitlab;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.antczak.bitbucket2gitlab.api.bitbucket.Issues;
import org.antczak.bitbucket2gitlab.api.bitbucket.Response;
import org.antczak.bitbucket2gitlab.api.gitlab.Issue;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    private Logger log = Logger.getLogger(Application.class);

    @Value("${bitbucket.username}")
    private String bitbucketUsername;
    @Value("${bitbucket.password}")
    private String bitbucketPassword;
    @Value("${bitbucket.project}")
    private String bitbucketProject;
    @Value("${bitbucket.api.issues}")
    private String bitbucketApiIssues;
    @Value("${bitbucket.statuses}")
    private String[] bitbucketStatuses;
    @Value("${bitbucket.add.status.to.labels}")
    private boolean bitbucketStatusToLabel;

    @Value("${gitlab.usertoken}")
    private String gitlabUsertoken;
    @Value("${gitlab.project}")
    private String gitlabProject;
    @Value("${gitlab.api.issues}")
    private String gitlabApiIssues;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void go() throws UnirestException, IOException {
        List<Issues> issues = importFromBitbucket();
        log.debug("Imported count: " + issues.size());

        for (Issues issueBitbucket : issues) {
            Issue issueGitlab = new Issue(issueBitbucket.getTitle(), issueBitbucket.getContent());
            issueGitlab.addLabel(issueBitbucket.getMetadata().getKind());
            issueGitlab.addLabel(issueBitbucket.getPriority());
            if (bitbucketStatusToLabel) {
                issueGitlab.addLabel(issueBitbucket.getStatus());
            }

            sendIssueToGitlab(issueGitlab);
        }
    }

    private void sendIssueToGitlab(Issue issue) throws UnirestException {
        String url = String.format(gitlabApiIssues, gitlabProject, gitlabUsertoken);
        HttpResponse<JsonNode> response = Unirest.post(url).fields(issue.getData()).asJson();
        log.debug(issue.getData());
        log.debug(response.getBody().toString());
    }

    private List<Issues> importFromBitbucket() throws UnirestException, IOException {
        List<Issues> issues = new ArrayList<>();

        int start = 0;
        int limit = 50;
        int count = 0;

        for (String status : bitbucketStatuses) {

            Response first = readChunk(start, limit, status);
            count = count + first.getCount().intValue();
            issues.addAll(first.getIssues());

            while (issues.size() != count) {
                issues.addAll(readChunk(issues.size(), limit, status).getIssues());
            }
        }

        return issues;
    }

    private Response readChunk(int start, int limit, String status) throws UnirestException, IOException {
        String url = String
            .format(bitbucketApiIssues, bitbucketUsername, bitbucketProject, limit, start,
                URLEncoder.encode(status, "UTF-8"));

        log.debug("Status: " + status + ", start: " + start + ", limit: " + limit + ", url: " + url);

        HttpResponse<JsonNode> rawResponse = Unirest.get(url).basicAuth(bitbucketUsername, bitbucketPassword).asJson();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper.readValue(rawResponse.getBody().toString(), Response.class);
    }
}
