package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore mockPrimary;
  private TorpedoStore mockSecondary;

  @BeforeEach
  public void init(){


    mockPrimary = mock(TorpedoStore.class);
    mockSecondary = mock(TorpedoStore.class);
      
    when(mockPrimary.fire(1)).thenReturn(true);
    when(mockSecondary.fire(1)).thenReturn(true);

    this.ship = new GT4500(mockPrimary,mockSecondary);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert

    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);


    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success_Twice_interaction(){
    // Arrange

    // Act
    for (int i = 0; i < 2; i++) {
      mockPrimary.fire(1);
    }
    

    // Assert
    verify(mockPrimary, times(2)).fire(1);
  }




}
