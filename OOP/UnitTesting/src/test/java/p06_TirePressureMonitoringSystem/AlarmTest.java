package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {

    Sensor sensor;
    Alarm alarm;

    @Before
    public void setUp(){
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }
    @Test
    public void testAlarmIsOnWhenLowPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(15.0);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenHighPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOffWhenNormalPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(19.0);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}