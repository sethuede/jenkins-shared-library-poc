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
    cps {
      script('''
jsl = library(
  identifier: "jenkins-shared-library@master",
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/durgaprasad444/jenkins-shared-library-poc.git',
      credentialsId: 'git_cred'
    ]
  )
)

pipeline_initialize()
    
      '''.stripIndent())
      sandbox()     
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
