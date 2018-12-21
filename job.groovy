job('DSL-Tutorial-1-Test') {
    scm {
        git('git://github.com/quidryan/aws-sdk-test.git')
    }
    triggers {
        scm('H/15 * * * *')
    }
    steps {
        maven('-e clean test')
    }
}

job('DSL-Tutorial-2-Test') {

    triggers {
        scm('H * * * *')
    }
    steps {
        maven('clean test')
    }
}

pipelineJob('example') {
    definition {
        cps {
            script(readFileFromWorkspace('project-a-workflow.groovy'))
            sandbox()
        }
    }
}