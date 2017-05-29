pipeline {
    agent any

    stages {
        stage('Build') {
			withMaven(
		        maven: 'M3',
			    )
 			sh "mvn clean install"
    		}
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}