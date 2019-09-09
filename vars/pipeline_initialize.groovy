def call() {
  node {
    def test = JOB_NAME
    def (name, value) = test.split("/")
    def (var1, var2) = value.split("_")
    def var3 = var1.replaceFirst('-','/')
       checkout([$class: 'GitSCM',
                 branches: [[name: "*/${var3}"]],
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
