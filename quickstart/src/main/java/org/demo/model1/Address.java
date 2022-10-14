package org.demo.model1;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerList;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Component

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
 String addressLine1;
 String addressLine2;
 long pincode;
}
