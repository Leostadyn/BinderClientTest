// IAidl.aidl
package com.leostadyn.stackfarm.bindertest;

// Declare any non-default types here with import statements
import com.leostadyn.stackfarm.bindertest.Person;
interface IAidl {
    void addPerson(in Person person);
    List<Person> getPersonList();
}
