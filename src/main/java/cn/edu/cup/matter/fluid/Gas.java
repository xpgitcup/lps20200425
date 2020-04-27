package cn.edu.cup.matter.fluid;

import cn.edu.cup.matter.CustomMatter;
import cn.edu.cup.matter.MatterType;

public class Gas extends CustomMatter {

    public Gas(String s) {
        super(s);
        setMatterType(MatterType.Gas);
    }
}
