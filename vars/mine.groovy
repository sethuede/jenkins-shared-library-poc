def call() {
  node {
    
    def p = pipelineCfg()
    def branch = p.branch
    def jobname = p.jobName
    def test = JOB_NAME
    def (name, value) = test.split("/")
    def (areho1, areho2) = value.split("_")
    def maha = areho1.replaceFirst('-','/')
     
       checkout([$class: 'GitSCM',
                 branches: [[name: "*/${p.branch}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            
          url: "https://github.com/durgaprasad444/${name}.git"
             ]]])
         sh """
         cd /var/lib/jenkins/workspace/${JOB_NAME}/
         ls
         echo ${name}
         echo ${maha}
         """
         sh "echo ${p.branch}"
         sh "echo ${p.test}"
        
  }
}
