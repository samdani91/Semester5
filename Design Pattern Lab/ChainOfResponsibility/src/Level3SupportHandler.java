public class Level3SupportHandler implements SupportHandler{
    private SupportHandler nexthandler;

    @Override
    public void handleRequest(Request request) {
        if(request.getPriority() == Priority.CRITICAL){
            System.out.println("Level 3 Support handled the request");
        }else{
            System.out.println("Request can't be handled");
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nexthandler = nextHandler;
    }
}
