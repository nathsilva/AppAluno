package com.example.appaluno;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Set;

public abstract class Conexao extends SQLiteOpenHelper{

    public static final String NOME_DO_BANCO = "dbAlunoCriar";
    public static final int VERSAO_DO_BANCO = 1;

    //CRIACAO BANCO DE DADOS
    public Conexao(@Nullable Context context){
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }

    //CRIACAO DA TABELA
    @Override
    public void onCreate(SQLiteDatabase db){
        String cria_tabela = "CREATE TABLE tbAluno(codigo INTEGER PRIMARY KEY, nome VARCHAR, email VARCHAR, telefone INT)";

        db.execSQL(cria_tabela);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String deleta_tabela = "DROP TABLE tbAluno";

        db.execSQL(deleta_tabela);
        onCreate(db);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    public static boolean delete(SQLiteDatabase db);
    String deleta_banco = "DROP DATABASE dbAlunoCriar";

        db.execSQL(deleta_banco);
        delete(db);
}
