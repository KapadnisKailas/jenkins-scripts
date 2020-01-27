job('spring-boot-demo-project-via-dsl'){
  description('maven project job created via dsl')
  scm{
    git('https://github.com/KapadnisKailas/spring-boot-demo-project.git', 'master'){ node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('KapadnisKailas')
            node / gitConfigEmail('kapadnis.kailas@gmail.com')
        }		
  }
  triggers{
    scm('H/45 * * * *')
  }
  steps{
    maven('clean package', 'pom.xml')
  }
  publishers{
    archiveArtifacts '**/*.jar'	
  } 		
}
