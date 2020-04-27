package cn.edu.cup.matter.solid;

import cn.edu.cup.matter.CustomMatter;
import cn.edu.cup.matter.MatterType;

public class Solid extends CustomMatter {

    public Solid(String s) {
        super(s);
        setMatterType(MatterType.Solid);
    }
}
