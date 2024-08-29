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
 '''

pipeline{
    agent any
    options{
        retry(2)
        timestamps()
    }
    stages{
        stage("SCM"){
            steps{
                git branch: 'main' , url: 'https://github.com/ElevenDevOps/eleven-devops-maven-repo.git'
                sh 'ls -lrt'

            }
        }
    }
 }

 
