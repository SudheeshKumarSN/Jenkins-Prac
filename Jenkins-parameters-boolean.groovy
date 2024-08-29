pipeline{
    agent any
    parameters{
        booleanParam( name: 'RUN_TEST', defaultValue: true, description: 'Do you want to run this job?')
    }
    stages{
        stage("CHECKOUT"){
            steps{
                sh "echo user wants to run this job"
                echo "${params.RUN_TEST}"
            }
        }
    }
}