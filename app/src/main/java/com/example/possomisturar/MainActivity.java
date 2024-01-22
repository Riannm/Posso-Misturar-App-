package com.example.possomisturar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FirebaseAuth auth;
    FirebaseAuth mAuth;
    FirebaseUser user;
    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner1 = findViewById(R.id.spinner_field1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.products_general, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(this);

        spinner2 = findViewById(R.id.spinner_field2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.products_general, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btn_menu_sobre) {
            Intent intent = new Intent(getApplicationContext(), Sobre.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.btn_menu_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Button combinar = findViewById(R.id.btn_combinar);
        ImageView placeholder1 = findViewById(R.id.placeholder_image1);
        ImageView placeholder2 = findViewById(R.id.placeholder_image2);
        TextView result = findViewById(R.id.result);
        TextView title = findViewById(R.id.title);

        int redColor = ContextCompat.getColor(this, R.color.red);
        int greenColor = ContextCompat.getColor(this, R.color.green);
        int yellowColor = ContextCompat.getColor(this, R.color.yellow);


        combinar.setText("Combinar");


        if (adapterView == spinner1) {
            switch (i) {
                case 0:
                    combinar.setText("Selecione Dois Itens");
                    break;
                case 1:
                    placeholder1.setImageResource(R.drawable.alcool_etilico_hidratado);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_alcool, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter3);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Misturar vinagre com álcool é seguro porque ambos são solúveis em água e são compostos não tóxicos. Além disso, a mistura não reage quimicamente de forma perigosa. No entanto, é importante lembrar que essa mistura em grandes quantidades pode ser prejudicial à saúde e que deve ser manuseada com cuidado.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.detergente_ype);

                                result.setText("Pode misturar! Detergente neutro misturado com o álcool têm um alto potencial de higienização. Esta mistura pode ser utilizada para limpar superfícies em que se deseja obter um brilho extra, como o piso ou uma bancada. É importante lembrar que o álcool é um produto inflamável, então jamais utilize esta mistura perto do fogo.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não devemos misturar álcool com água sanitária porque essa combinação pode produzir uma reação química que gera clorofórmio e outros compostos potencialmente tóxicos. O clorofórmio é um composto nocivo e irritante, podendo causar problemas nos pulmões, rins e na pele.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 2:
                    placeholder1.setImageResource(R.drawable.alcool_gel);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_alcool, android.R.layout.simple_spinner_item);
                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter4);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Misturar vinagre com álcool é seguro porque ambos são solúveis em água e são compostos não tóxicos. Além disso, a mistura não reage quimicamente de forma perigosa. No entanto, é importante lembrar que essa mistura em grandes quantidades pode ser prejudicial à saúde e que deve ser manuseada com cuidado.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.detergente_ype);

                                result.setText("Pode misturar! Detergente neutro misturado com o álcool têm um alto potencial de higienização. Esta mistura pode ser utilizada para limpar superfícies em que se deseja obter um brilho extra, como o piso ou uma bancada. É importante lembrar que o álcool é um produto inflamável, então jamais utilize esta mistura perto do fogo.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não devemos misturar álcool com água sanitária porque essa combinação pode produzir uma reação química que gera clorofórmio e outros compostos potencialmente tóxicos. O clorofórmio é um composto nocivo e irritante, podendo causar problemas nos pulmões, rins e na pele.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 3:
                    placeholder1.setImageResource(R.drawable.alcool_etilico_hidratado);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_alcool, android.R.layout.simple_spinner_item);
                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter5);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Misturar vinagre com álcool é seguro porque ambos são solúveis em água e são compostos não tóxicos. Além disso, a mistura não reage quimicamente de forma perigosa. No entanto, é importante lembrar que essa mistura em grandes quantidades pode ser prejudicial à saúde e que deve ser manuseada com cuidado.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.detergente_ype);

                                result.setText("Pode misturar! Detergente neutro misturado com o álcool têm um alto potencial de higienização. Esta mistura pode ser utilizada para limpar superfícies em que se deseja obter um brilho extra, como o piso ou uma bancada. É importante lembrar que o álcool é um produto inflamável, então jamais utilize esta mistura perto do fogo.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não devemos misturar álcool com água sanitária porque essa combinação pode produzir uma reação química que gera clorofórmio e outros compostos potencialmente tóxicos. O clorofórmio é um composto nocivo e irritante, podendo causar problemas nos pulmões, rins e na pele.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 4:
                    placeholder1.setImageResource(R.drawable.agua_oxigenada);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_agua_oxigenada, android.R.layout.simple_spinner_item);
                    adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter6);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não devemos misturar água oxigenada com vinagre porque a mistura gera ácido peracético, substância corrosiva, ou seja que pode causar queimaduras na pele e danos as superfícies, além de causar danos ao meio ambiente.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("A mistura entre água sanitária e água oxigenada libera gás oxigênio que não é nocivo, mas dependendo da concentração dos produtos a liberação de gás pode ser intensa e associada ao calor liberado na reação pode levar a explosões. É importante não misturar produtos químicos sem a orientação de um profissional capacitado.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            }
                        }
                    });

                    break;
                case 5:
                    placeholder1.setImageResource(R.drawable.agua_oxigenada);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_agua_oxigenada, android.R.layout.simple_spinner_item);
                    adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter7);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não devemos misturar água oxigenada com vinagre porque a mistura gera ácido peracético, substância corrosiva, ou seja que pode causar queimaduras na pele e danos as superfícies, além de causar danos ao meio ambiente.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("A mistura entre água sanitária e água oxigenada libera gás oxigênio que não é nocivo, mas dependendo da concentração dos produtos a liberação de gás pode ser intensa e associada ao calor liberado na reação pode levar a explosões. É importante não misturar produtos químicos sem a orientação de um profissional capacitado.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            }
                        }
                    });

                    break;
                case 6:
                    placeholder1.setImageResource(R.drawable.medicamentos);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_antibiotico, android.R.layout.simple_spinner_item);
                    adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter8);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Antibióticos e bebidas alcoólicas podem ter interações negativas que podem reduzir a eficácia do medicamento, aumentar a toxicidade do álcool ou do medicamento ou causar sintomas indesejáveis, como náuseas, vômitos e dores de cabeça. É importante seguir as instruções de dosagem do medicamento e evitar o consumo de álcool durante o tratamento com antibióticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.leite);

                                result.setText("Não se recomenda misturar antibióticos com leite, pois o cálcio presente no leite pode inibir a absorção do medicamento pelo organismo, diminuindo seu efeito. Além disso, a ingestão de leite pode provocar irritação no estômago, especialmente em algumas pessoas.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 7:
                    placeholder1.setImageResource(R.drawable.liquor_alcohol);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_bebidas_alcoólicas, android.R.layout.simple_spinner_item);
                    adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter9);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.medicamentos);

                                result.setText("Antibióticos e bebidas alcoólicas podem ter interações negativas que podem reduzir a eficácia do medicamento, aumentar a toxicidade do álcool ou do medicamento ou causar sintomas indesejáveis, como náuseas, vômitos e dores de cabeça. É importante seguir as instruções de dosagem do medicamento e evitar o consumo de álcool durante o tratamento com antibióticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.medium_loratadina);

                                result.setText("Não é seguro misturar bebida alcoólica com loratadina, pois o álcool pode aumentar os efeitos colaterais da loratadina e diminuir a eficácia do medicamento. Além disso, a mistura pode levar a problemas de sedação e comprometimento da capacidade de dirigir ou operar máquinas. É importante sempre seguir as orientações médicas e farmacêuticas em relação ao uso de medicamentos e álcool.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.dipirona_sodica);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.paracetamol_gotas);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 8:
                    placeholder1.setImageResource(R.drawable.cerveja);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_bebidas_alcoólicas, android.R.layout.simple_spinner_item);
                    adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter10);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.medicamentos);

                                result.setText("Antibióticos e bebidas alcoólicas podem ter interações negativas que podem reduzir a eficácia do medicamento, aumentar a toxicidade do álcool ou do medicamento ou causar sintomas indesejáveis, como náuseas, vômitos e dores de cabeça. É importante seguir as instruções de dosagem do medicamento e evitar o consumo de álcool durante o tratamento com antibióticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.medium_loratadina);

                                result.setText("Não é seguro misturar bebida alcoólica com loratadina, pois o álcool pode aumentar os efeitos colaterais da loratadina e diminuir a eficácia do medicamento. Além disso, a mistura pode levar a problemas de sedação e comprometimento da capacidade de dirigir ou operar máquinas. É importante sempre seguir as orientações médicas e farmacêuticas em relação ao uso de medicamentos e álcool.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.dipirona_sodica);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.paracetamol_gotas);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 9:
                    placeholder1.setImageResource(R.drawable.cachaca);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_bebidas_alcoólicas, android.R.layout.simple_spinner_item);
                    adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter11);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.medicamentos);

                                result.setText("Antibióticos e bebidas alcoólicas podem ter interações negativas que podem reduzir a eficácia do medicamento, aumentar a toxicidade do álcool ou do medicamento ou causar sintomas indesejáveis, como náuseas, vômitos e dores de cabeça. É importante seguir as instruções de dosagem do medicamento e evitar o consumo de álcool durante o tratamento com antibióticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.medium_loratadina);

                                result.setText("Não é seguro misturar bebida alcoólica com loratadina, pois o álcool pode aumentar os efeitos colaterais da loratadina e diminuir a eficácia do medicamento. Além disso, a mistura pode levar a problemas de sedação e comprometimento da capacidade de dirigir ou operar máquinas. É importante sempre seguir as orientações médicas e farmacêuticas em relação ao uso de medicamentos e álcool.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.dipirona_sodica);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.paracetamol_gotas);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 10:
                    placeholder1.setImageResource(R.drawable.liquor_alcohol);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_bebidas_alcoólicas, android.R.layout.simple_spinner_item);
                    adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter12);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.medicamentos);

                                result.setText("Antibióticos e bebidas alcoólicas podem ter interações negativas que podem reduzir a eficácia do medicamento, aumentar a toxicidade do álcool ou do medicamento ou causar sintomas indesejáveis, como náuseas, vômitos e dores de cabeça. É importante seguir as instruções de dosagem do medicamento e evitar o consumo de álcool durante o tratamento com antibióticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.medium_loratadina);

                                result.setText("Não é seguro misturar bebida alcoólica com loratadina, pois o álcool pode aumentar os efeitos colaterais da loratadina e diminuir a eficácia do medicamento. Além disso, a mistura pode levar a problemas de sedação e comprometimento da capacidade de dirigir ou operar máquinas. É importante sempre seguir as orientações médicas e farmacêuticas em relação ao uso de medicamentos e álcool.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.dipirona_sodica);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.paracetamol_gotas);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 11:
                    placeholder1.setImageResource(R.drawable.medium_loratadina);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_loratadina, android.R.layout.simple_spinner_item);
                    adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter13);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não é seguro misturar bebida alcoólica com loratadina, pois o álcool pode aumentar os efeitos colaterais da loratadina e diminuir a eficácia do medicamento. Além disso, a mistura pode levar a problemas de sedação e comprometimento da capacidade de dirigir ou operar máquinas. É importante sempre seguir as orientações médicas e farmacêuticas em relação ao uso de medicamentos e álcool.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            }
                        }
                    });

                    break;
                case 12:
                    placeholder1.setImageResource(R.drawable.medium_loratadina);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_loratadina, android.R.layout.simple_spinner_item);
                    adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter14);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não é seguro misturar bebida alcoólica com loratadina, pois o álcool pode aumentar os efeitos colaterais da loratadina e diminuir a eficácia do medicamento. Além disso, a mistura pode levar a problemas de sedação e comprometimento da capacidade de dirigir ou operar máquinas. É importante sempre seguir as orientações médicas e farmacêuticas em relação ao uso de medicamentos e álcool.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            }
                        }
                    });

                    break;
                case 13:
                    placeholder1.setImageResource(R.drawable.medium_loratadina);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_loratadina, android.R.layout.simple_spinner_item);
                    adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter15);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não é seguro misturar bebida alcoólica com loratadina, pois o álcool pode aumentar os efeitos colaterais da loratadina e diminuir a eficácia do medicamento. Além disso, a mistura pode levar a problemas de sedação e comprometimento da capacidade de dirigir ou operar máquinas. É importante sempre seguir as orientações médicas e farmacêuticas em relação ao uso de medicamentos e álcool.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            }
                        }
                    });

                    break;
                case 14:
                    placeholder1.setImageResource(R.drawable.paracetamol_gotas);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_paracetamol, android.R.layout.simple_spinner_item);
                    adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter16);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 15:
                    placeholder1.setImageResource(R.drawable.paracetamol_gotas);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_paracetamol, android.R.layout.simple_spinner_item);
                    adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter17);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 16:
                    placeholder1.setImageResource(R.drawable.paracetamol_gotas);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_paracetamol, android.R.layout.simple_spinner_item);
                    adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter18);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 17:
                    placeholder1.setImageResource(R.drawable.paracetamol_gotas);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_paracetamol, android.R.layout.simple_spinner_item);
                    adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter19);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 18:
                    placeholder1.setImageResource(R.drawable.paracetamol_gotas);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_paracetamol, android.R.layout.simple_spinner_item);
                    adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter20);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não podemos misturar bebida alcoólica com paracetamol porque a combinação pode danificar o fígado e aumentar o risco de problemas hepáticos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 19:
                    placeholder1.setImageResource(R.drawable.dipirona_sodica);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_dipirona, android.R.layout.simple_spinner_item);
                    adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter21);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.leite);

                                result.setText("Não há evidências de que misturar Dipirona com Leite seja perigoso. No entanto, é importante lembrar que misturar medicamentos com outros produtos pode interferir na forma como o medicamento é absorvido pelo corpo, o que pode afetar sua eficácia. Portanto, é sempre recomendável seguir as instruções do médico ou farmacêutico e evitar misturar medicamentos com outros produtos sem orientação adequada.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 20:
                    placeholder1.setImageResource(R.drawable.dipirona_sodica);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_dipirona, android.R.layout.simple_spinner_item);
                    adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter22);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.leite);

                                result.setText("Não há evidências de que misturar Dipirona com Leite seja perigoso. No entanto, é importante lembrar que misturar medicamentos com outros produtos pode interferir na forma como o medicamento é absorvido pelo corpo, o que pode afetar sua eficácia. Portanto, é sempre recomendável seguir as instruções do médico ou farmacêutico e evitar misturar medicamentos com outros produtos sem orientação adequada.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 21:
                    placeholder1.setImageResource(R.drawable.dipirona_sodica);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter23 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_dipirona, android.R.layout.simple_spinner_item);
                    adapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter23);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.leite);

                                result.setText("Não há evidências de que misturar Dipirona com Leite seja perigoso. No entanto, é importante lembrar que misturar medicamentos com outros produtos pode interferir na forma como o medicamento é absorvido pelo corpo, o que pode afetar sua eficácia. Portanto, é sempre recomendável seguir as instruções do médico ou farmacêutico e evitar misturar medicamentos com outros produtos sem orientação adequada.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 22:
                    placeholder1.setImageResource(R.drawable.dipirona_sodica);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter24 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_dipirona, android.R.layout.simple_spinner_item);
                    adapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter24);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.leite);

                                result.setText("Não há evidências de que misturar Dipirona com Leite seja perigoso. No entanto, é importante lembrar que misturar medicamentos com outros produtos pode interferir na forma como o medicamento é absorvido pelo corpo, o que pode afetar sua eficácia. Portanto, é sempre recomendável seguir as instruções do médico ou farmacêutico e evitar misturar medicamentos com outros produtos sem orientação adequada.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 23:
                    placeholder1.setImageResource(R.drawable.dipirona_sodica);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter25 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_dipirona, android.R.layout.simple_spinner_item);
                    adapter25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter25);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.leite);

                                result.setText("Não há evidências de que misturar Dipirona com Leite seja perigoso. No entanto, é importante lembrar que misturar medicamentos com outros produtos pode interferir na forma como o medicamento é absorvido pelo corpo, o que pode afetar sua eficácia. Portanto, é sempre recomendável seguir as instruções do médico ou farmacêutico e evitar misturar medicamentos com outros produtos sem orientação adequada.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 24:
                    placeholder1.setImageResource(R.drawable.dipirona_sodica);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter26 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_dipirona, android.R.layout.simple_spinner_item);
                    adapter26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter26);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.liquor_alcohol);

                                result.setText("Não se deve misturar bebida alcoólica com dipirona porque o álcool aumenta a toxicidade do medicamento, podendo prejudicar o fígado e causar outros efeitos colaterais graves.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.leite);

                                result.setText("Não há evidências de que misturar Dipirona com Leite seja perigoso. No entanto, é importante lembrar que misturar medicamentos com outros produtos pode interferir na forma como o medicamento é absorvido pelo corpo, o que pode afetar sua eficácia. Portanto, é sempre recomendável seguir as instruções do médico ou farmacêutico e evitar misturar medicamentos com outros produtos sem orientação adequada.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 25:
                    placeholder1.setImageResource(R.drawable.detergente_ype);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter27 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_detergente, android.R.layout.simple_spinner_item);
                    adapter27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter27);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.alcool_etilico_hidratado);

                                result.setText("Pode misturar! Detergente neutro misturado com o álcool têm um alto potencial de higienização. Esta mistura pode ser utilizada para limpar superfícies em que se deseja obter um brilho extra, como o piso ou uma bancada. É importante lembrar que o álcool é um produto inflamável, então jamais utilize esta mistura perto do fogo.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com sabão ou detergente não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.hiperideal_bicabornato_de_sodio);

                                result.setText("Pode misturar! Detergente neutro misturado com o bicarbonato de sódio não promove reação química, então esta mistura é segura. Dependendo da proporção entre os produtos esta forma uma mistura com características abrasivas.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 26:
                    placeholder1.setImageResource(R.drawable.detergente_ype);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter28 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_detergente, android.R.layout.simple_spinner_item);
                    adapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter28);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.alcool_etilico_hidratado);

                                result.setText("Pode misturar! Detergente neutro misturado com o álcool têm um alto potencial de higienização. Esta mistura pode ser utilizada para limpar superfícies em que se deseja obter um brilho extra, como o piso ou uma bancada. É importante lembrar que o álcool é um produto inflamável, então jamais utilize esta mistura perto do fogo.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com sabão ou detergente não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.hiperideal_bicabornato_de_sodio);

                                result.setText("Pode misturar! Detergente neutro misturado com o bicarbonato de sódio não promove reação química, então esta mistura é segura. Dependendo da proporção entre os produtos esta forma uma mistura com características abrasivas.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 27:
                    placeholder1.setImageResource(R.drawable.detergente_ype);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter29 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_detergente, android.R.layout.simple_spinner_item);
                    adapter29.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter29);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.alcool_etilico_hidratado);

                                result.setText("Pode misturar! Detergente neutro misturado com o álcool têm um alto potencial de higienização. Esta mistura pode ser utilizada para limpar superfícies em que se deseja obter um brilho extra, como o piso ou uma bancada. É importante lembrar que o álcool é um produto inflamável, então jamais utilize esta mistura perto do fogo.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com sabão ou detergente não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.hiperideal_bicabornato_de_sodio);

                                result.setText("Pode misturar! Detergente neutro misturado com o bicarbonato de sódio não promove reação química, então esta mistura é segura. Dependendo da proporção entre os produtos esta forma uma mistura com características abrasivas.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 28:
                    placeholder1.setImageResource(R.drawable.sabao_em_po_tixan_yp_5kg);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter30 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_sabao_po, android.R.layout.simple_spinner_item);
                    adapter30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter30);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com detergente em pó não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 29:
                    placeholder1.setImageResource(R.drawable.sabao_em_po_tixan_yp_5kg);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter31 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_sabao_po, android.R.layout.simple_spinner_item);
                    adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter31);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com detergente em pó não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 30:
                    placeholder1.setImageResource(R.drawable.vinagre);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter32 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_vinagre, android.R.layout.simple_spinner_item);
                    adapter32.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter32);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.alcool_etilico_hidratado);

                                result.setText("Misturar vinagre com álcool é seguro porque ambos são solúveis em água e são compostos não tóxicos. Além disso, a mistura não reage quimicamente de forma perigosa. No entanto, é importante lembrar que essa mistura em grandes quantidades pode ser prejudicial à saúde e que deve ser manuseada com cuidado.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_oxigenada);

                                result.setText("Não devemos misturar água oxigenada com vinagre porque a mistura gera ácido peracético, substância corrosiva, ou seja que pode causar queimaduras na pele e danos as superfícies, além de causar danos ao meio ambiente.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não é seguro misturar vinagre (ácido acético) com água sanitária (hipoclorito de sódio), pois isso pode formar uma reação química que libera gás cloro, que é altamente tóxico e pode causar problemas respiratórios e irritações na pele e nos olhos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.desinfetante);

                                result.setText("Não devemos misturar vinagre com desinfetante porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 5) {

                                placeholder2.setImageResource(R.drawable.desinfetante_lysoform);

                                result.setText("Não devemos misturar vinagre com Lisoform porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 6) {

                                placeholder2.setImageResource(R.drawable.hiperideal_bicabornato_de_sodio);

                                result.setText("Vinagre e bicarbonato de sódio são seguros para serem misturados porque a reação química entre eles gera dióxido de carbono, água e acetato de sódio, que são compostos não tóxicos e comuns em nossa vida cotidiana. No entanto, é importante tomar cuidado com a quantidade utilizada, pois a reação pode ser violenta se adicionado em excesso. Além disso, evite o contato com os olhos e a pele, e sempre faça a mistura em um recipiente adequado.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 31:
                    placeholder1.setImageResource(R.drawable.vinagre);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter33 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_vinagre, android.R.layout.simple_spinner_item);
                    adapter33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter33);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.alcool_etilico_hidratado);

                                result.setText("Misturar vinagre com álcool é seguro porque ambos são solúveis em água e são compostos não tóxicos. Além disso, a mistura não reage quimicamente de forma perigosa. No entanto, é importante lembrar que essa mistura em grandes quantidades pode ser prejudicial à saúde e que deve ser manuseada com cuidado.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_oxigenada);

                                result.setText("Não devemos misturar água oxigenada com vinagre porque a mistura gera ácido peracético, substância corrosiva, ou seja que pode causar queimaduras na pele e danos as superfícies, além de causar danos ao meio ambiente.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não é seguro misturar vinagre (ácido acético) com água sanitária (hipoclorito de sódio), pois isso pode formar uma reação química que libera gás cloro, que é altamente tóxico e pode causar problemas respiratórios e irritações na pele e nos olhos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.desinfetante);

                                result.setText("Não devemos misturar vinagre com desinfetante porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 5) {

                                placeholder2.setImageResource(R.drawable.desinfetante_lysoform);

                                result.setText("Não devemos misturar vinagre com Lisoform porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 6) {

                                placeholder2.setImageResource(R.drawable.hiperideal_bicabornato_de_sodio);

                                result.setText("Vinagre e bicarbonato de sódio são seguros para serem misturados porque a reação química entre eles gera dióxido de carbono, água e acetato de sódio, que são compostos não tóxicos e comuns em nossa vida cotidiana. No entanto, é importante tomar cuidado com a quantidade utilizada, pois a reação pode ser violenta se adicionado em excesso. Além disso, evite o contato com os olhos e a pele, e sempre faça a mistura em um recipiente adequado.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 32:
                    placeholder1.setImageResource(R.drawable.agua_sanitaria_ype);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter34 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_agua_sanitaria, android.R.layout.simple_spinner_item);
                    adapter34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter34);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.alcool_etilico_hidratado);

                                result.setText("Não devemos misturar álcool com água sanitária porque essa combinação pode produzir uma reação química que gera clorofórmio e outros compostos potencialmente tóxicos. O clorofórmio é um composto nocivo e irritante, podendo causar problemas nos pulmões, rins e na pele.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_oxigenada);

                                result.setText("A mistura entre água sanitária e água oxigenada libera gás oxigênio que não é nocivo, mas dependendo da concentração dos produtos a liberação de gás pode ser intensa e associada ao calor liberado na reação pode levar a explosões. É importante não misturar produtos químicos sem a orientação de um profissional capacitado.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.detergente_ype);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com sabão ou detergente não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.sabao_em_po_tixan_yp_5kg);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com detergente em pó não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 5) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não é seguro misturar vinagre (ácido acético) com água sanitária (hipoclorito de sódio), pois isso pode formar uma reação química que libera gás cloro, que é altamente tóxico e pode causar problemas respiratórios e irritações na pele e nos olhos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 6) {

                                placeholder2.setImageResource(R.drawable.desinfetante);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 7) {

                                placeholder2.setImageResource(R.drawable.desinfetante_lysoform);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 8) {

                                placeholder2.setImageResource(R.drawable.acucar);

                                result.setText("Não pode misturar! Não devemos misturar água sanitária com açúcar, já que esta combinação pode formar ácido clorídrico e gás cloro que são nocivos à saúde e além de causar irritações na pele, olhos e vias respiratórias. Além disso, essa reação pode gerar calor e até mesmo levar a explosões.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 33:
                    placeholder1.setImageResource(R.drawable.agua_sanitaria_ype);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter35 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_agua_sanitaria, android.R.layout.simple_spinner_item);
                    adapter35.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter35);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.alcool_etilico_hidratado);

                                result.setText("Não devemos misturar álcool com água sanitária porque essa combinação pode produzir uma reação química que gera clorofórmio e outros compostos potencialmente tóxicos. O clorofórmio é um composto nocivo e irritante, podendo causar problemas nos pulmões, rins e na pele.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_oxigenada);

                                result.setText("A mistura entre água sanitária e água oxigenada libera gás oxigênio que não é nocivo, mas dependendo da concentração dos produtos a liberação de gás pode ser intensa e associada ao calor liberado na reação pode levar a explosões. É importante não misturar produtos químicos sem a orientação de um profissional capacitado.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.detergente_ype);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com sabão ou detergente não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.sabao_em_po_tixan_yp_5kg);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com detergente em pó não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 5) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não é seguro misturar vinagre (ácido acético) com água sanitária (hipoclorito de sódio), pois isso pode formar uma reação química que libera gás cloro, que é altamente tóxico e pode causar problemas respiratórios e irritações na pele e nos olhos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 6) {

                                placeholder2.setImageResource(R.drawable.desinfetante);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 7) {

                                placeholder2.setImageResource(R.drawable.desinfetante_lysoform);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 8) {

                                placeholder2.setImageResource(R.drawable.acucar);

                                result.setText("Não pode misturar! Não devemos misturar água sanitária com açúcar, já que esta combinação pode formar ácido clorídrico e gás cloro que são nocivos à saúde e além de causar irritações na pele, olhos e vias respiratórias. Além disso, essa reação pode gerar calor e até mesmo levar a explosões.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 34:
                    placeholder1.setImageResource(R.drawable.agua_sanitaria_ype);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter36 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_agua_sanitaria, android.R.layout.simple_spinner_item);
                    adapter36.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter36);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.alcool_etilico_hidratado);

                                result.setText("Não devemos misturar álcool com água sanitária porque essa combinação pode produzir uma reação química que gera clorofórmio e outros compostos potencialmente tóxicos. O clorofórmio é um composto nocivo e irritante, podendo causar problemas nos pulmões, rins e na pele.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_oxigenada);

                                result.setText("A mistura entre água sanitária e água oxigenada libera gás oxigênio que não é nocivo, mas dependendo da concentração dos produtos a liberação de gás pode ser intensa e associada ao calor liberado na reação pode levar a explosões. É importante não misturar produtos químicos sem a orientação de um profissional capacitado.");
                                title.setTextColor(yellowColor);
                                title.setText("Pode Misturar! Porém...");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.detergente_ype);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com sabão ou detergente não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 4) {

                                placeholder2.setImageResource(R.drawable.sabao_em_po_tixan_yp_5kg);

                                result.setText("Não pode misturar! Ao contrário do que se pensa, misturar água sanitária (cloro) com detergente em pó não potencializa a ação de limpeza. Esta mistura promove uma reação de neutralização, e em alguns casos de detergente/sabão com grupo amina ocorre a formação de cloroaminas, que prejudicam as vias respiratórias.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 5) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não é seguro misturar vinagre (ácido acético) com água sanitária (hipoclorito de sódio), pois isso pode formar uma reação química que libera gás cloro, que é altamente tóxico e pode causar problemas respiratórios e irritações na pele e nos olhos.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 6) {

                                placeholder2.setImageResource(R.drawable.desinfetante);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 7) {

                                placeholder2.setImageResource(R.drawable.desinfetante_lysoform);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 8) {

                                placeholder2.setImageResource(R.drawable.acucar);

                                result.setText("Não pode misturar! Não devemos misturar água sanitária com açúcar, já que esta combinação pode formar ácido clorídrico e gás cloro que são nocivos à saúde e além de causar irritações na pele, olhos e vias respiratórias. Além disso, essa reação pode gerar calor e até mesmo levar a explosões.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 35:
                    placeholder1.setImageResource(R.drawable.desinfetante);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter37 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_desinfetante, android.R.layout.simple_spinner_item);
                    adapter37.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter37);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não devemos misturar vinagre com desinfetante porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 36:
                    placeholder1.setImageResource(R.drawable.desinfetante);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter38 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_desinfetante, android.R.layout.simple_spinner_item);
                    adapter38.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter38);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não devemos misturar vinagre com desinfetante porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 37:
                    placeholder1.setImageResource(R.drawable.desinfetante_veja);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter39 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_desinfetante, android.R.layout.simple_spinner_item);
                    adapter39.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter39);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não devemos misturar vinagre com desinfetante porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 38:
                    placeholder1.setImageResource(R.drawable.ajax_desinfetante);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter40 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_desinfetante, android.R.layout.simple_spinner_item);
                    adapter40.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter40);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não devemos misturar vinagre com desinfetante porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 39:
                    placeholder1.setImageResource(R.drawable.desinfetante_lysoform);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter41 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_desinfetante, android.R.layout.simple_spinner_item);
                    adapter41.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter41);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Não devemos misturar vinagre com Lisoform porque a mistura pode produzir gases tóxicos que podem ser prejudiciais à saúde. Além disso, a mistura pode inativar a ação desinfetante dos produtos, tornando-os menos eficazes na eliminação de bactérias e vírus.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não se deve misturar água sanitária com desinfetantes, que geralmente são à base de amoníacos, pois ocorre uma reação química que libera compostos do tipo cloroaminas, que se inaladas, podem causar problemas de saúde que vão desde alergias até intoxicações e queimaduras.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 40:
                    placeholder1.setImageResource(R.drawable.hiperideal_bicabornato_de_sodio);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter42 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_bicabornato_de_sodio, android.R.layout.simple_spinner_item);
                    adapter42.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter42);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.vinagre);

                                result.setText("Vinagre e bicarbonato de sódio são seguros para serem misturados porque a reação química entre eles gera dióxido de carbono, água e acetato de sódio, que são compostos não tóxicos e comuns em nossa vida cotidiana. No entanto, é importante tomar cuidado com a quantidade utilizada, pois a reação pode ser violenta se adicionado em excesso. Além disso, evite o contato com os olhos e a pele, e sempre faça a mistura em um recipiente adequado.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.detergente_ype);

                                result.setText("Pode misturar! Detergente neutro misturado com o bicarbonato de sódio não promove reação química, então esta mistura é segura. Dependendo da proporção entre os produtos esta forma uma mistura com características abrasivas.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 41:
                    placeholder1.setImageResource(R.drawable.leite);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter43 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_leite, android.R.layout.simple_spinner_item);
                    adapter43.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter43);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.medicamentos);

                                result.setText("Não se recomenda misturar antibióticos com leite, pois o cálcio presente no leite pode inibir a absorção do medicamento pelo organismo, diminuindo seu efeito. Além disso, a ingestão de leite pode provocar irritação no estômago, especialmente em algumas pessoas.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 2) {

                                placeholder2.setImageResource(R.drawable.dipirona_sodica);

                                result.setText("Não há evidências de que misturar Dipirona com Leite seja perigoso. No entanto, é importante lembrar que misturar medicamentos com outros produtos pode interferir na forma como o medicamento é absorvido pelo corpo, o que pode afetar sua eficácia. Portanto, é sempre recomendável seguir as instruções do médico ou farmacêutico e evitar misturar medicamentos com outros produtos sem orientação adequada.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            } else if (spinner2.getSelectedItemPosition() == 3) {

                                placeholder2.setImageResource(R.drawable.manga);

                                result.setText("Não há nenhum risco conhecido em misturar leite com manga. Ambos são alimentos seguros e não reagem quimicamente quando combinados. No entanto, algumas pessoas podem ter intolerância à lactose ou alergia à manga, o que pode causar reações negativas.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 42:
                    placeholder1.setImageResource(R.drawable.manga);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter44 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_manga, android.R.layout.simple_spinner_item);
                    adapter44.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter44);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.leite);

                                result.setText("Não há nenhum risco conhecido em misturar leite com manga. Ambos são alimentos seguros e não reagem quimicamente quando combinados. No entanto, algumas pessoas podem ter intolerância à lactose ou alergia à manga, o que pode causar reações negativas.");
                                title.setTextColor(greenColor);
                                title.setText("Pode Misturar!");

                            }
                        }
                    });

                    break;
                case 43:
                    placeholder1.setImageResource(R.drawable.acucar);

                    spinner2 = findViewById(R.id.spinner_field2);
                    ArrayAdapter<CharSequence> adapter45 = ArrayAdapter.createFromResource(MainActivity.this, R.array.products_for_acucar, android.R.layout.simple_spinner_item);
                    adapter45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter45);

                    combinar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (spinner2.getSelectedItemPosition() == 0) {

                                combinar.setText("Selecione Dois Itens");

                            } else if (spinner2.getSelectedItemPosition() == 1) {

                                placeholder2.setImageResource(R.drawable.agua_sanitaria_ype);

                                result.setText("Não pode misturar! Não devemos misturar água sanitária com açúcar, já que esta combinação pode formar ácido clorídrico e gás cloro que são nocivos à saúde e além de causar irritações na pele, olhos e vias respiratórias. Além disso, essa reação pode gerar calor e até mesmo levar a explosões.");
                                title.setTextColor(redColor);
                                title.setText("Não Pode Misturar!");

                            }
                        }
                    });

                    break;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Button combinar = findViewById(R.id.btn_combinar);
        ImageView placeholder1 = findViewById(R.id.placeholder_image1);
        ImageView placeholder2 = findViewById(R.id.placeholder_image2);

        combinar.setText("Selecione Dois Produtos!");
        placeholder1.setImageResource(R.drawable.base_bg);
        placeholder2.setImageResource(R.drawable.base_bg);
    }
}