package com.dcl;

import javax.persistence.*;

@Entity
public class Sample {
   int id;

   @Id
   public int getId() {
      return this.id;
   }

   public void setId(int id) {
	   // Set Id will be used to set the fields instead of the fields directly if the 
	   // 
      this.id = id;
   }
}
