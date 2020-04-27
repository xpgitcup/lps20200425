/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.cup.hydraulic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LiXiaoping
 */
public class Pipeline extends HydraulicUnit {

    public Pipeline(String s) {
        super(s);
        setHydraulicUnitType(HydraulicUnitType.Pipeline);
        setModel(s);
    }

    @Override
    public void exportToFile() {
        super.exportToFile();
        getHydralicChildren().forEach((e) -> {
            e.exportToFile();
        });
    }

    public void fillSampleData(int k) {
        getHydralicChildren().stream().filter((e) -> (e instanceof Pipe)).forEachOrdered((e) -> {
            ((Pipe) e).fillSampleProfile(k);
        });
    }

    public void autoCreatePipe() {
        int n = getHydralicChildren().size();
        HydraulicUnit e, ee, p;
        Map<HydraulicUnit, HydraulicUnit> pipes = new HashMap<>();
        String pmode;
        String sname;

        for (int i = 0; i < n - 1; i++) {
            e = getHydralicChildren().get(i);
            ee = getHydralicChildren().get(i + 1);
            if ((e instanceof Station) && (ee instanceof Station)) {
                sname = e.getModel();
                pmode = sname + "-" + ee.getModel();
                p = new Pipe(pmode);
                p.setDataPath(getDataPath());
                pipes.put(ee, p);

                System.out.println(p);
            }
        }

        pipes.keySet().forEach((es) -> {
            int i = getHydralicChildren().indexOf(es);
            System.out.println("站点：" + es);
            getHydralicChildren().add(i, pipes.get(es));
        });

        System.out.println(getHydralicChildren());

        updateChildren();
    }
}
