package node;

import lombok.Getter;

@Getter
public abstract class IRStatement extends Node{
    public String declaration;
    public String label;
}
