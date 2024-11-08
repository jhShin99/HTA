package net.common.action;

/**
 * Action 인터페이스를 구현한 클래스에서 명령 수행 후 다음 페이지로 이동하기 위한 정보를 담을 클래스입니다.
 * redirect는 redirect 여부, path에는 페이지 정보가 저장됩니다.
 *
 * 1. redirect가 true이면
 *    response.sendRedirect(forward.getPath()); 문장을 실행합니다.
 *
 * 2. redirect가 false이면
 *    RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
 */
public class ActionForward {
    private boolean redirect = false;
    private String path = null;

    //property redirect의 is 메서드
    public boolean isRedirect() {
        //프로퍼티 타입이 boolean일 경우 get 대신 is를 앞에 붙일 수 있습니다.
        return redirect;
    }

    //property redirect의 set 메서드
    public void setRedirect(boolean b) {
        redirect = b;
    }

    //property path의 get 메서드
    public String getPath() {
        return path;
    }

    //property path의 set 메서드
    public void setPath(String string) {
        path = string;
    }
}
