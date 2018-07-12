package ru.spb.gu.app;

import sun.security.pkcs11.Secmod;

import static ru.spb.gu.pages.title.Locators.*;

public class SelectorModules {

    public String[] getModule(ModuleGroups groupModule, Modules module){
        switch (groupModule){
            case SERVICE: return new String[]{serviceTab, getServiceModules(module)};
            case CIVILREGISTRATION: return new String[]{civilRegistrationTab, getCivilregistrationModules(module)};
            case REPORTS: return new String[]{reportsTab, getReportsModules(module)};
            case TECH: return new String[]{techTab, getTechModules(module)};
        }
        return new String[0];
    }
    public String getServiceModules(Modules module){
        switch (module){
            case ARMDO: return armDO;
            case ARMSMEVRESPONSE: return armSmevResponse;
            case ARMSMEVREQUEST: return armSmevRequest;
            case ARMIOGVEMPLOYEE: return armIogvEmployee;
            case ARMGISGMP: return armGisGmp;
            case TICKETSIOGV: return ticketsIogv;
        }
        return "Not found";
    }

    public String getCivilregistrationModules(Modules module){
        switch (module){
            case ZAGSMARRIAGE: return zagsMarriage;
            case ZAGSDIVORCE: return zagsDivorce;
        }
        return "Not found";
    }

    public String getReportsModules(Modules module){
        switch (module){
            case UNLOADER: return unloader;
            case UNLOADSLOADER: return uploadsLoader;
            case OVERDUEREQUESTS: return overdueRequests;
        }
        return "Not found";
    }

    public String getTechModules(Modules module){
        switch (module){
            case TECHSUPPORT: return techSupport;
        }
        return "Not found";
    }


}
