package com.example.mvvmapp.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Update;

import com.example.mvvmapp.RoomDB.Information;
import com.example.mvvmapp.RoomDB.InformationDao;
import com.example.mvvmapp.RoomDB.InformationRoomDatabase;
import com.example.mvvmapp.view.Part9RoomDBActivity;

import java.util.List;

//AndroidViewModel to room estefade mikonim k farghrsh ba ViewModel adi to constructor hast k context ro inja bema mide onja nadarimesh.
//ViewModel = ertebate View + Model =======>
//az Viewmodel baraye ertebate    Information(Database)ya(Model)   ba    Part9RoomDBActivity(View)    estefade mikoinm
//

public class ViewModelRoomDB extends AndroidViewModel {

    private InformationDao informationDao;
    private InformationRoomDatabase informationRoomDatabase;
    private LiveData<List<Information>> allInformation;

    public ViewModelRoomDB(@NonNull Application application) {
        super(application);

        informationRoomDatabase = InformationRoomDatabase.getInstance(application);
        informationDao = informationRoomDatabase.getInformationDao();
        allInformation = informationDao.getAllInformation();
    }


    public LiveData<List<Information>> getAllInformation() {
            return allInformation;
    }

    private class InsertInformationAsyncTask extends AsyncTask<Information,Void,Void>{

        InformationDao mInformationDao;

        public InsertInformationAsyncTask(InformationDao InformationDao) {
            mInformationDao = InformationDao;
        }


        @Override
        protected Void doInBackground(Information... information) {
            mInformationDao.insertInformation(information[0]);
            return null;
        }
    }
    //sabete hamash - edameye AsyncTask
    public void insertInformation(Information information){
        new InsertInformationAsyncTask(informationDao).execute(information);
    }


    private class DeleteInformationAsyncTask extends AsyncTask<Information,Void,Void>{

        InformationDao mInformationDao;

        public DeleteInformationAsyncTask(InformationDao InformationDao) {
            mInformationDao = InformationDao;
        }


        @Override
        protected Void doInBackground(Information... information) {
            mInformationDao.deleteInformation(information[0]);
            return null;
        }
    }

    public void deleteInformation(Information information){
        new DeleteInformationAsyncTask(informationDao).execute(information);
    }



    private class UpdateInformationAsyncTask extends AsyncTask<Information,Void,Void>{

        InformationDao mInformationDao;

        public UpdateInformationAsyncTask(InformationDao InformationDao) {
            mInformationDao = InformationDao;
        }


        @Override
        protected Void doInBackground(Information... information) {
            mInformationDao.updateInformation(information[0]);;
            return null;
        }
    }

    public void updateInformation(Information information){
        new UpdateInformationAsyncTask(informationDao).execute(information);
    }



    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
