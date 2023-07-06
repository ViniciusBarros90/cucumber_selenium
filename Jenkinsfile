pipeline {
    agent any

        stages {
        stage('Build Bugbank') {
                       steps {
                           // Download do projeto de teste unitário
                           bat 'echo Baixando o Bugbank'
                           git 'https://github.com/qaacademy/bugbank.git'
                           bat 'yarn'
                           bat 'echo Bugbank está em execução'

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

   stage('Testes E2E') {
               steps {
                   // Download do projeto de teste unitário
                   bat 'echo baixando testes e2e'
                   git 'https://github.com/ViniciusBarros90/cucumber_selenium.git'
                   bat 'mvn clean install -Dtest=Runner test'


                                     }
                  }
    }

}
