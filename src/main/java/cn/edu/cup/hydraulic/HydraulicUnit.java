package cn.edu.cup.hydraulic;

import cn.edu.cup.commondata.CustomObject;
import cn.edu.cup.commondata.DataValueType;
import cn.edu.cup.equipment.*;
import cn.edu.cup.matter.CustomMatter;
import cn.edu.cup.matter.MatterType;
import cn.edu.cup.matter.fluid.Gas;
import cn.edu.cup.matter.fluid.Liquid;
import cn.edu.cup.matter.solid.Solid;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class HydraulicUnit extends CustomObject {

    private HydraulicUnitType hydraulicUnitType;
    private final List<HydraulicUnit> hydralicChildren;
    private final List<CustomMatter> hydralicContent;

    public HydraulicUnit(String s) {
        super();
        setHydraulicUnitType(HydraulicUnitType.Undefined);
        setModel(s);
        hydralicChildren = new ArrayList<>();
        hydralicContent = new ArrayList<>();
    }

    @Override
    protected void setupRawData() {
        super.setupRawData(); //To change body of generated methods, choose Tools | Templates.
        newChild("");
        newContent("");
    }

    public void updateContent() {
        String childrenString = "";
        for (int i = 0; i < getHydralicContent().size(); i++) {
            childrenString += getHydralicContent().get(i).toString();
            if (i < getHydralicContent().size() - 1) {
                childrenString += " ";
            }
        }
        getRawData().getDataItems().get("包含").setValueString(childrenString);
    }
    
    public void updateChildren() {
        String childrenString = "";
        for (int i = 0; i < getHydralicChildren().size(); i++) {
            childrenString += getHydralicChildren().get(i).toString();
            if (i < getHydralicChildren().size() - 1) {
                childrenString += " ";
            }
        }
        getRawData().getDataItems().get("子节点列表").setValueString(childrenString);
    }

    @Override
    public void importFromFile() {
        super.importFromFile();
        // 处理子节点
        String[] children = getChildren();
        if ((children != null) && (children.length > 0)) {
            processChildren(children);
        }
        // 处理包含项
        String[] content = getContent();
        if ((content != null) && (content.length > 0)) {
            processContent(content);
        }
    }
    
    private void processContent(String[] content) {
        for (String e : content) {
            LOG.log(Level.INFO, "处理包含:{0}", e);
            hydralicContent.add(createHydraulicContent(e));
        }
    }

    private void processChildren(String[] children) {
        for (String e : children) {
            LOG.log(Level.INFO, "处理子节点:{0}", e);
            hydralicChildren.add(createHydraulicUnit(e));
        }
    }
    
    private CustomMatter createHydraulicContent(String e) {
        String[] config = e.split(":");
        MatterType matterType = MatterType.valueOf(config[0]);
        CustomMatter matter = null;
        switch (matterType) {
            case Undefined:
                break;
            case Liquid:
                matter = new Liquid(config[1]);
                break;
            case Solid:
                matter = new Solid(config[1]);
                break;
            case Gas:
                matter = new Gas(config[1]);
                break;
            default:
                break;
        }

        if (matter != null) {
            matter.setDataPath(getDataPath());
            matter.importFromFile();
        }

        return matter;
    }

    private HydraulicUnit createHydraulicUnit(String e) {
        String[] config = e.split(":");
        HydraulicUnitType huType = HydraulicUnitType.valueOf(config[0]);
        HydraulicUnit hydraulicUnit = null;
        switch (huType) {
            case Undefined:
                break;
            case Pipeline:
                hydraulicUnit = new Pipeline(config[1]);
                break;
            case Station:
                hydraulicUnit = new Station(config[1]);
                break;
            case Pipe:
                hydraulicUnit = new Pipe(config[1]);
                break;
            case Source:
                hydraulicUnit = new EquipmentSource(config[1]);
                break;
            case Sink:
                hydraulicUnit = new EquipmentSink(config[1]);
                break;
            case IdealPump:
                hydraulicUnit = new EquipmentIdealPump(config[1]);
                break;
            case Pump:
                hydraulicUnit = new EquipmentPump(config[1]);
                break;
            case CentrifugalPump:
                hydraulicUnit = new EquipmentCentrifugalPump(config[1]);
                break;
            case ReciprocatingPump:
                hydraulicUnit = new EquipmentReciprocatingPump(config[1]);
                break;
            case CustomValve:
                hydraulicUnit = new EquipmentCustomValve(config[1]);
                break;
            case RegulatingValve:
                hydraulicUnit = new EquipmentRegulatingValve(config[1]);
                break;
            case CutOffValve:
                hydraulicUnit = new EquipmentCutOffValve(config[1]);
                break;
            case PressureReliefValve:
                hydraulicUnit = new EquipmentPressureReliefValve(config[1]);
                break;
            case SafetyValve:
                hydraulicUnit = new EquipmentSafetyValve(config[1]);
                break;
            case ReliefValve:
                hydraulicUnit = new EquipmentReliefValve(config[1]);
                break;
            case Heater:
                hydraulicUnit = new EquipmentHeater(config[1]);
                break;
            case Flowmeter:
                hydraulicUnit = new EquipmentFlowmeter(config[1]);
                break;
            case Tank:
                hydraulicUnit = new EquipmentTank(config[1]);
                break;
            default:
                break;
        }

        if (hydraulicUnit != null) {
            hydraulicUnit.setDataPath(getDataPath());
            hydraulicUnit.importFromFile();
        }

        return hydraulicUnit;
    }

    @Override
    public void exportToFile() {
        super.exportToFile(); //To change body of generated methods, choose Tools | Templates.
        getHydralicChildren().forEach((e) -> {
            e.exportToFile();
        });
        getHydralicContent().forEach((e)->{
            e.exportToFile();
        });
    }

    public void display() {
        System.out.println(this.toString());
        getHydralicChildren().forEach((e) -> {
            e.display();
        });
        getHydralicContent().forEach((e)->{
            e.display();
        });
    }

    @Override
    public String getDataFileName() {
        return getDataPath() + "/" + getModel() + "." + getHydraulicUnitType().toString() + ".json";
    }

    public HydraulicUnitType getHydraulicUnitType() {
        return hydraulicUnitType;
    }

    public List<HydraulicUnit> getHydralicChildren() {
        return hydralicChildren;
    }

    public List<CustomMatter> getHydralicContent() {
        return hydralicContent;
    }

    protected void setHydraulicUnitType(HydraulicUnitType hydraulicUnitType) {
        this.hydraulicUnitType = hydraulicUnitType;
        setName(this.hydraulicUnitType.toString());
    }

    public void newContent(String typeNameAndName) {
        getRawData().newItem("包含", DataValueType.object, "", typeNameAndName);
    }

    public void newChild(String typeNameAndName) {
        getRawData().newItem("子节点列表", DataValueType.object, "", typeNameAndName);
    }

    public String[] getContent() {
        String item = getRawData().getDataItems().get("包含").getValueString();
        if ((item == null) || item.isEmpty()) {
            return null;
        } else {
            return item.split(" ");
        }
    }
    
    public String[] getChildren() {
        String item = getRawData().getDataItems().get("子节点列表").getValueString();
        if ((item == null) || item.isEmpty()) {
            return null;
        } else {
            return item.split(" ");
        }
    }

}
