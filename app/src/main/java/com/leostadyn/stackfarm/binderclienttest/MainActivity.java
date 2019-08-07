package com.leostadyn.stackfarm.binderclienttest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.leostadyn.stackfarm.bindertest.IAidl;
import com.leostadyn.stackfarm.bindertest.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IAidl iAidl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
    }

    private void bindService(){
        Intent intent=new Intent();
        intent.setComponent(new ComponentName(
                "com.leostadyn.stackfarm.bindertest",
                "com.leostadyn.stackfarm.bindertest.AidlService")
        );
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iAidl=IAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void click(View view) {
        try {
            iAidl.addPerson(new Person("leostadyn",10));
            List<Person> personList=iAidl.getPersonList();
            Log.d("KKKK",personList.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

