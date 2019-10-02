package com.example.tecsup.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Dog d= new Dog("Firulais",10);

        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(d);
        Person p=realm.createObject(Person.class,2);

        p.name ="Cesar Milan";
        p.dogs.add(d);
        realm.commitTransaction();

        RealmResults<Dog>cachorros=realm.where(Dog.class).findAll();
        Toast.makeText(this,cachorros.size()+"",Toast.LENGTH_SHORT).show();

        cachorros.addChangeListener(new RealmChangeListener<RealmResults<Dog>>() {
            @Override
            public void onChange(RealmResults<Dog> dogs) {

            }
        });

       // realm.beginTransaction();
       // cachorros.get(0).deleteFromRealm();
        // realm.commitTransaction();




    }

}
