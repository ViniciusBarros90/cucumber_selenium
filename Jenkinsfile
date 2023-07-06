pipeline {
    agent any

        stages {
        stage('Build') {
            steps {
                // Download do projeto de teste unitário
                sh 'echo Inicio dos testes unitarios  Baixando projeto https://github.com/ViniciusBarros90/cucumber_selenium.git'
                git 'https://github.com/ViniciusBarros90/cucumber_selenium.git'

                // Executar os testes unitarios usando Maven
                bat "mvn clean install test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
