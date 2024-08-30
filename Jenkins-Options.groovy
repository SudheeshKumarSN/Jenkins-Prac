''' OPTIONS:
 "options" are used to define specific behaviors or settings that apply to the entire pipeline or specific stages within the pipeline.
 
 1) Options for entire pipeline:

 a)timeout - sets the max time to run the pipeline after  reaching the specfic time  the pipeline will stop executing:
      ex: options {
                    timeout(time: 30, unit: 'MINUTES')
                  }
 b)retry - it will retry's the job for the mentioned number
      ex: options{
                 retry(3)
                 }

 c)buildDiscarder- Controls how many builds to keep and for how long.
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

 d)disableConcurrentBuilds - Prevents multiple builds from running concurrently.

    options {
        disableConcurrentBuilds()
    }

 e)timestamps - Adds timestamps to the console output.

    options {
        timestamps()
    }

 f)skipDefaultCheckout - Prevents the default checkout step from happening.

    options {
        skipDefaultCheckout()
    }

 g)preserveStashes - Keeps stashes for a specific number of builds.

    options {
        preserveStashes(buildCount: 5)
    }

Stage-Level Options
These options are applied within a specific stage and only affect that stage.

a)timeout - Sets a timeout for a particular stage.

    stage('Build') {
        options {
            timeout(time: 15, unit: 'MINUTES')
        }
        steps {
            // build steps
        }
    }

b)retry - Retries a particular stage a specified number of times if it fails.

stage('Test') {
    options {
        retry(2)
    }
    steps {
        // test steps
    }
}

c)skipDefaultCheckout - Prevents the default checkout in a specific stage.

    stage('Deploy') {
        options {
            skipDefaultCheckout()
        }
        steps {
            // deploy steps
        }
    }

d)dockerLabel - Sets a label for the Docker containers used in the stage.

    stage('Test') {
        options {
            dockerLabel('my-docker-label')
        }
        steps {
            // steps using docker
        }
    }
 '''

pipeline{
    agent any
    options{
        retry(2)
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
        
    stages{
        stage("SCM"){
            options{
                retry(3)
            }
            steps{
                git branch: 'main' , url: 'https://github.com/ElevenDevOps/eleven-devops-maven-repo.git'
                sh 'ls -lrt'

            }
        }
    }
 }

 
