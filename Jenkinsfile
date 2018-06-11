pipeline {
	agent any
	
	environment {
	    CI = 'JENKINS'
	}


	tools {
		maven 'apache-maven-latest'
	}
	
	stages {
		stage('Build') {
			steps {
				sh 'rm -rf ~/.m2/repository/org/eclipse/scada'
				sh 'rm -rf ~/.m2/repository/org/eclipse/neoscada'
				sh 'MAVEN_OPTS="-Xms1024m -Xmx3072m" mvn -B -Dorg.slf4j.simpleLogger.defaultLogLevel=INFO  -Dmaven.test.failure.ignore=true -Dmaven.test.skip=true clean install'
			}
		}
		stage('Archive') {
			steps {
				archiveArtifacts '**/*-p2/target/*p2-*.zip'
				archiveArtifacts '**/*-product/target/products/*.tar.gz'
				archiveArtifacts '**/*-product/target/products/*.zip'
				archiveArtifacts '**/*-p2/target/*p2_*.deb'
				archiveArtifacts '**/*-p2/target/*p2-*.rpm'
				archiveArtifacts 'releng/org.eclipse.neoscada.releng.publish/generated/src/main/resources/buildinfo.properties'
			}
		}
		stage('Deploy') {
			steps {
				sh 'find $WORKSPACE/b/assemble'
			}
		}
	}
}