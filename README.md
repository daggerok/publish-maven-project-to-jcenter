# publish maven projects to jcenter bintray

## build

```shell script
./mvnw
```

## run

```shell script
java -jar app/target/*-all.jar
```

# publish project artifacts as maven repository to local filesystem

```shell script
./mvnw -P publish-locally
```

## maven-release-plugin

```shell script
./mvnw clean
./mvnw -Dresume=false -DdryRun=true release:prepare
./mvnw -Dresume=false release:prepare release:perform
```

## publish project artifacts as maven repository to github

```shell script
./mvnw clean
./mvnw -P publish-locally
# create manually on your github repository branch: maven
./mvnw -P publish-to-github -pl :publish-maven-project-to-jcenter
```

## upload github release

* prepare [settings.xml](settings.xml) file:
  ```shell script
  cp -Rf settings.template.xml settings.xml
  ```
* update it accordingly: //servers/server/github
* run commands:
  ```shell script
  ./mvnw clean package
  ./mvnw -P upload-github-release -pl :publish-maven-project-to-jcenter -s settings.xml
  ```

## publish project artifacts to bintray jcenter maven repository

* update [settings.xml](./settings.xml) file accordingly //servers/server/bintray-daggerok-repo
  username => bintray API key
* prepare / perform release
* checkout manually to created tag and/or trigger via CI job automatically project tag artifacts publishing to jcenter bintray maven repository:

_TODO: implements me..._

_links_

* [fix IDEA ${maven.multiModuleProjectDirectory} problem](https://stackoverflow.com/questions/29983683/dmaven-multimoduleprojectdirectory-not-set-issue-with-maven-and-intellij)
