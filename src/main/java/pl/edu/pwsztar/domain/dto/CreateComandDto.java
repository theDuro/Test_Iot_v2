package pl.edu.pwsztar.domain.dto;

import java.io.Serializable;

public class CreateComandDto implements Serializable {
    private Float ledLimitedValue;
    private Float ledFrequency ;
    private Float enginePower;
    private Long userId;

    public CreateComandDto() {
    }
    public CreateComandDto( float ledLimitedValue,float ledFrequency,float enginePower,long userId) {
        this.ledLimitedValue = ledLimitedValue;
        this.ledFrequency = ledFrequency;
        this.enginePower = enginePower;
        this.userId= userId;
    }
    @Override
    public String toString() {
        return "CreateCmandDto{" +
                ",ledLimitedValue='" + ledLimitedValue + '\'' +
                ", ledFrequency='" + ledFrequency + '\'' +
                ", enginePower=" + enginePower +
                ", userId=" + userId +
                '}';
    }

    public Float getLedLimitedValue() {
        return ledLimitedValue;
    }

    public Float getLedFrequency() {
        return ledFrequency;
    }

    public Float getEnginePower() {
        return enginePower;
    }

    public Long getUserId() {
        return userId;
    }
}
