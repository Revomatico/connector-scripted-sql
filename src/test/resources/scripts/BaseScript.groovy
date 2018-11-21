class BaseScript extends Script {

//    def log = log as Log
//
//    log.info ( "Base script executed" )

    final def MY_CONSTANT = "vilko"

    @Override
    Object run() {
        throw new UnsupportedOperationException("not implemented yet")
    }
}