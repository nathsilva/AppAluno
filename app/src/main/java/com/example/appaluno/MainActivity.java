package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //criando banco de dados
            SQLiteDatabase bd = openOrCreateDatabase("dbAlunoCriar", MODE_PRIVATE, null);

            //criando tabela
            bd.execSQL("CREATE TABLE IF NOT EXISTS tbAluno (nome VARCHAR, email VARCHAR, telefone INT)");

            //inserindo dados na tabela
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Alfredo','alfredo12@etec.com.br','55468519')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Afonso','afonso22@etec.com.br','52457814')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Paulo','paulinho1@etec.com.br','54859748')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Patricia','patricia2@etec.com.br','25451236')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Roberto','roberto100@etec.com.br','12457898')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Raquel','raquel08@etec.com.br','58545696')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Bruno','bruno55@etec.com.br','78984562')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Bruna','bruna55@etec.com.br','96587412')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Marcio','marcinho@etec.com.br','54879626')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Nathalia','nathalia@etec.com.br','55269426')");

            //busca de dados
            Cursor cursor = bd.rawQuery("SELECT nome, email, telefone FROM tbAluno", null);

            //qual coluna pega os valorees
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            //guia o cursor para o inicio da tabela
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));

                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
