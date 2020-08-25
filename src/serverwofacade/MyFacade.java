/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author GP63
 */
public class MyFacade {

    /**
     * @param args the command line arguments
     */
    private static MyFacade myFacadeObj = null;
    ScheduleServer scheduleServer = new ScheduleServer();
    private MyFacade() {}
    public static MyFacade getMyFacadeObject(){
        if(myFacadeObj == null){
            myFacadeObj = new MyFacade();
        }
        return myFacadeObj;
    }
    public void classStart() {
        scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
    } 
    public void classEnd() {
        scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}
