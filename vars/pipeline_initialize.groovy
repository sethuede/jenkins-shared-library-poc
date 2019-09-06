def call() {
  node {
    def test = JOB_NAME
    def (name, value) = test.split("/")
    def (areho1, areho2) = value.split("_")
    def maha = areho1.replaceFirst('-','/')
       checkout([$class: 'GitSCM',
                 branches: [[name: "*/${maha}"]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[
            
          url: "https://github.com/durgaprasad444/${name}.git"
             ]]])
   
   
   def p = pipelineCfg()

   switch(p.pipelineType) {
      case 'python':
        // Instantiate and execute a Python pipeline
            mine()
   }
   switch(p.pipelineType) {
      case 'maven':
        // Instantiate and execute a Python pipeline
            test()
    
   }
   }
}
