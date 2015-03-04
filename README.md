bitbucket-2-gitlab
===============

Migrate your issues from Bitbucket to GitLab with one, easy step (API->API).

Update application.properties
```properties
bitbucket.username=<bitbucket user name>
bitbucket.password=<bitbucket password>
bitbucket.project=<bitbucket project name>

gitlab.usertoken=<gitlab user token>
gitlab.project=<gitlab user project id> #read yours here: https://gitlab.com/api/v3/projects?private_token=<token>

#what to import?
bitbucket.statuses=new,open,resolved,on hold,invalid,duplicate,wontfix #which statues do you want to migrate
bitbucket.add.status.to.labels=false #migrate bitbucket status as gitlab label?

bitbucket.api.issues=https://bitbucket.org/api/1.0/repositories/%s/%s/issues/?limit=%d&start=%d&status=%s
gitlab.api.issues=https://gitlab.com/api/v3/projects/%S/issues?private_token=%s
```
run
```
mvn spring-boot:run
```