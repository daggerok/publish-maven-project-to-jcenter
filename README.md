# publish maven projects to jcenter bintray [![Build Status](https://travis-ci.org/daggerok/publish-maven-project-to-jcenter.svg?branch=master)](https://travis-ci.org/daggerok/publish-maven-project-to-jcenter)

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

_dry run_

```shell script
./mvnw clean
./mvnw --batch-mode release:clean \
                    release:prepare \
                    release:perform \
                      -Dresume=false \
                      -DdryRun=true \
                      -DgenerateBackupPoms=false \
                      -Darguments="-DskipTests" \
                      -DskipTests \
                      -s ./settings.xml
#if something goes wrong:
#./mvnw release:rollback
```

_release_

```shell script
./mvnw release:clean release:prepare release:perform \
        -Pmaven-release-plugin,publish-to-github -s ./settings.xml \
        -DgenerateBackupPoms=false \
        -Dresume=false \
        -DdryRun=false \
        -DskipTests \
        --batch-mode
#if something goes wrong:
#./mvnw release:rollback -s ./settings.xml
```

<!--

```shell script
./mvnw clean
./mvnw --batch-mode -Dresume=false -DdryRun=true release:clean release:prepare -DgenerateReleasePoms=false
# if everything is great:
./mvnw --batch-mode -Dresume=false -DdryRun=true release:clean
./mvnw --batch-mode -Dresume=false release:prepare release:perform -s ./settings.xml
# if errors occurs:
#./mvnw release:rollback
```

-->

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
  ./mvnw -P upload-github-release -pl :publish-maven-project-to-jcenter -s ./settings.xml
  ```

## publish project artifacts to bintray jcenter maven repository

* update [settings.xml](./settings.xml) file accordingly //servers/server/bintray-daggerok-repo
  username => bintray API key
* prepare / perform release
* checkout manually to created tag and/or trigger via CI job automatically project tag artifacts publishing to jcenter bintray maven repository:

_TODO: implements me..._

_links_

* [fix IDEA ${maven.multiModuleProjectDirectory} problem](https://stackoverflow.com/questions/29983683/dmaven-multimoduleprojectdirectory-not-set-issue-with-maven-and-intellij)
* [maven-release-plugin](https://maven.apache.org/maven-release/maven-release-plugin/examples/update-versions.html)
