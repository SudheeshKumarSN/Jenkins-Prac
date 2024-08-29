pipeline{
    agent any
    parameters{
        booleanParam( name: 'RUN_TEST', defaultvalue: 'true', description: 'Do you want to run this job?')
    }
    stages{
        stage("CHECKOUT"){
            stages{
                sh " echo user wants to run this job"
                echo "${param.RUN_TEST}"
            }
        }
    }
}