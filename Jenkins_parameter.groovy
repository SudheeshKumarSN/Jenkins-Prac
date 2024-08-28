pipeline{
    agent any
    parameters{ choice(name: 'BRANCH_NAME', choices: ['main', 'develop'], description: 'The Git branch to build') }
    environment{
        REPO_URL = 'https://github.com/ElevenDevOps/eleven-devops-maven-repo.git'
    }
    stages{
        stage("checkout"){
            steps{
                git branch: "${params.BRANCH_NAME}" , url: "${env.REPO_URL}"
                echo "${params.BRANCH_NAME}"
                sh 'ls -lrt'
            }
        }
    }
}