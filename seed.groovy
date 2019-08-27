def createfoldername(jobName) {
  
   folder(jobName) {
       displayName(jobName)
       description(jobName)
}
}
def durga() {
  def foldername = jobName
createfoldername(foldername)
}
durga()
def createDeploymentJob(jobName, repoUrl) {
    pipelineJob(jobName) {
        
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                        branches("*/" + branch)
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("myfile")
            }
        }
    }
}
def buildPipelineJobs() {
    def repo = "https://github.com/durgaprasad444/"
    def repoUrl = repo + jobName + ".git"
    def branchname = branch.replaceAll('/','-')
    def deployName = jobName + "/" + branchname + "_pipeline"
    
    createDeploymentJob(deployName, repoUrl)
}
buildPipelineJobs()
