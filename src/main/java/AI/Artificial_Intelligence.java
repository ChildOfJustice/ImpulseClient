package AI;

import FrameSys.FrameSysCore;





public class Artificial_Intelligence {
    //Main Core and analyzer



    public static void analyzeAction(String action) {
        if (action.equals("connect")) {
            FrameSysCore.setCursor("WAIT");
            FrameSysCore.addText(Integer.toString(FrameSysCore.getPort()));
            FrameSysCore.addText(FrameSysCore.getServerIp());
            //Connection.connect();
            FrameSysCore.setCursor("NORMAL");
        } else {

        }
    }

}
