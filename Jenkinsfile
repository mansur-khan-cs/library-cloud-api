pipeline {

	agent any
	environment {
		PROJECT_ID = 'my-k8s-project-300415'
		CLUSTER_NAME = 'library-cloud-api-k8-cluster'
		LOCATION = 'europe-west1'
		CREDENTIALS_ID = 'my-k8s-project'
	}
	
	stages {
		stage ('Scm Checkout') {
			steps {
                // GIT submodule recursive checkout
                checkout scm: [
                        $class: 'GitSCM',
                        branches: scm.branches,
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [[$class: 'SubmoduleOption',
                                      disableSubmodules: false,
                                      parentCredentials: false,
                                      recursiveSubmodules: true,
                                      reference: '',
                                      trackingSubmodules: false]],
                        submoduleCfg: [],
                        userRemoteConfigs: scm.userRemoteConfigs
                ]
                // copy managed files to workspace
                script {
                    if(params.USE_INPUT_DUNS) {
                        configFileProvider([configFile(fileId: '609999e4-446c-4705-a024-061ed7ca2a11',
                                targetLocation: 'input/')]) {
                            echo 'Managed file copied to workspace'
                        }
                    }
                }
            }
		}
		
		stage ('Build') {
			steps {
				echo "Cleaning and building jar file"
				
				sh 'mvn clean install'
				
			}				
		}
		
		stage ('Test') {
			steps {
				echo  "Testing.."
				sh 'mvn test'
			}
		}
		
		stage ('Build Docker Image') {
			steps {
				sh 'whoami'
				script {
					myimage = docker.build("zahirulislam/library-cloud-api:${env.BUILD_ID}")					
				}
			}
		}
		
		stage ('Push Docker image to Dockerhub') {
			steps{
				script {
					docker.withRegistry( '', 'Dockerhub' ) { 
                      dockerImage.push() 
                    }
				}
			}
		}
	}
}