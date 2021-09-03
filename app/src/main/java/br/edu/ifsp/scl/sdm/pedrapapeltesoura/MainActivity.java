package br.edu.ifsp.scl.sdm.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

import br.edu.ifsp.scl.sdm.pedrapapeltesoura.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());


        //lambda
        activityMainBinding.mostrarOpcoesSw.setOnCheckedChangeListener( (__, mostrarOpcoes) -> {
            activityMainBinding.selecionarOpcaoLl.setVisibility(mostrarOpcoes?View.VISIBLE:View.GONE );
        });



       /* activityMainBinding.mostrarOpcoesSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean mostraropcoes) {
                activityMainBinding.selecionarOpcaoLl.setVisibility(mostraropcoes?View.VISIBLE:View.GONE );
            }
        });

        */

    }


    public void onClick(View view) {
        int jogada = -1;
        switch (view.getId()){
            case R.id.pedraIb:
                jogada=R.mipmap.pedra;
                break;
            case R.id.papelIb:
                jogada=R.mipmap.papel;
                break;
            case R.id.tesouraIb:
                jogada=R.mipmap.tesoura;
                break;
        }

        activityMainBinding.suaJoagadaIv.setImageResource(jogada);


        if (!(activityMainBinding.mostrarOpcoesSw.isChecked())) {
            jogarJokenpo(jogada);
        } else if (activityMainBinding.mostrarOpcoesSw.isChecked()) {
            jogarJokenpo2(jogada);
        }


    }

    private void jogarJokenpo(int jogada){
        Random random =new Random(System.currentTimeMillis());
        int jogadaComputador = random.nextInt(4);

        //setando imagem da jogada do computador

        int imagemJogadaComputadorId=-1;
        switch (jogadaComputador){
            case 0:
                imagemJogadaComputadorId=R.mipmap.pedra;
                break;
            case 1:
                imagemJogadaComputadorId=R.mipmap.papel;
                break;
            case 2:
                imagemJogadaComputadorId=R.mipmap.tesoura;
                break;
            default:
                break;
        }
        activityMainBinding.jogadaComputadorIv.setImageResource(imagemJogadaComputadorId);

        StringBuilder resultadoSb = new StringBuilder();

        if(jogada==imagemJogadaComputadorId){
            resultadoSb.append(" Empate!");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
        } else if((jogada==R.mipmap.papel && imagemJogadaComputadorId==R.mipmap.tesoura)
                || (jogada==R.mipmap.tesoura && imagemJogadaComputadorId==R.mipmap.pedra)
                || (jogada==R.mipmap.pedra && imagemJogadaComputadorId==R.mipmap.papel)){
            resultadoSb.append(" Você Perdeu!");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
        } else {
            resultadoSb.append(" Você GANHOU!");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
        }
    }
    private void jogarJokenpo2(int jogada){
        Random random =new Random(System.currentTimeMillis());
        int jogadaComputador = random.nextInt(4);
        int jogadaComputador2 = random.nextInt(4);

        //setando imagem da jogada do computador

        int imagemJogadaComputadorId=-1;
        switch (jogadaComputador){
            case 0:
                imagemJogadaComputadorId=R.mipmap.pedra;
                break;
            case 1:
                imagemJogadaComputadorId=R.mipmap.papel;
                break;
            case 2:
                imagemJogadaComputadorId=R.mipmap.tesoura;
                break;
            default:
                break;
        }

        int imagemJogadaComputadorId2=-1;
        switch (jogadaComputador2){
            case 0:
                imagemJogadaComputadorId2=R.mipmap.pedra;
                break;
            case 1:
                imagemJogadaComputadorId2=R.mipmap.papel;
                break;
            case 2:
                imagemJogadaComputadorId2=R.mipmap.tesoura;
                break;
            default:
                break;
        }
        activityMainBinding.jogadaComputadorIv.setImageResource(imagemJogadaComputadorId);
        activityMainBinding.jogadaComputador2Iv.setImageResource(imagemJogadaComputadorId2);

        StringBuilder resultadoSb = new StringBuilder();

        if(jogada==imagemJogadaComputadorId && jogada==imagemJogadaComputadorId2){
            resultadoSb.append(" Empate!");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
        } else if((jogada==R.mipmap.papel && imagemJogadaComputadorId==R.mipmap.tesoura
                && imagemJogadaComputadorId2==R.mipmap.tesoura)
                || (jogada==R.mipmap.tesoura && imagemJogadaComputadorId==R.mipmap.pedra
                && imagemJogadaComputadorId2==R.mipmap.pedra)
                || (jogada==R.mipmap.pedra && imagemJogadaComputadorId==R.mipmap.papel
                && imagemJogadaComputadorId2==R.mipmap.papel)){
            resultadoSb.append(" Você Perdeu!");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
            //
        } else if(jogada==R.mipmap.papel && imagemJogadaComputadorId==R.mipmap.tesoura
                &&imagemJogadaComputadorId2==R.mipmap.pedra){
            resultadoSb.append(" Você Perdeu para o Computador 1 e ganhou do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.pedra && imagemJogadaComputadorId==R.mipmap.papel
                && imagemJogadaComputadorId2==R.mipmap.tesoura){
            resultadoSb.append(" Você Perdeu para o Computador 1 e ganhou do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.tesoura && imagemJogadaComputadorId==R.mipmap.pedra
                && imagemJogadaComputadorId2==R.mipmap.papel){
            resultadoSb.append(" Você Perdeu para o Computador 1 e ganhou do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
            /****/
        } else if(jogada==R.mipmap.papel && imagemJogadaComputadorId2==R.mipmap.tesoura
                &&imagemJogadaComputadorId==R.mipmap.pedra){
            resultadoSb.append(" Você Perdeu para o Computador 2 e ganhou do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.pedra && imagemJogadaComputadorId2==R.mipmap.papel
                && imagemJogadaComputadorId==R.mipmap.tesoura){
            resultadoSb.append(" Você Perdeu para o Computador 2 e ganhou do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.tesoura && imagemJogadaComputadorId2==R.mipmap.pedra
                && imagemJogadaComputadorId==R.mipmap.papel){
            resultadoSb.append(" Você Perdeu para o Computador 2 e ganhou do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
            /****/
        }else if(jogada==R.mipmap.papel && imagemJogadaComputadorId==R.mipmap.pedra
                &&imagemJogadaComputadorId2==R.mipmap.tesoura){
            resultadoSb.append(" Você Ganhou do Computador 1 e perdeu do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.pedra && imagemJogadaComputadorId==R.mipmap.tesoura
                && imagemJogadaComputadorId2==R.mipmap.papel){
            resultadoSb.append(" Você Ganhou do Computador 1 e perdeu do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.tesoura && imagemJogadaComputadorId==R.mipmap.papel
                && imagemJogadaComputadorId2==R.mipmap.pedra){
            resultadoSb.append(" Você Ganhou do Computador 1 e perdeu do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
            /****/
        } else if(jogada==R.mipmap.papel && imagemJogadaComputadorId2==R.mipmap.pedra
                &&imagemJogadaComputadorId==R.mipmap.tesoura){
            resultadoSb.append(" Você Ganhou do Computador 2 e perdeu do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.pedra && imagemJogadaComputadorId2==R.mipmap.tesoura
                && imagemJogadaComputadorId==R.mipmap.papel){
            resultadoSb.append(" Você Ganhou do Computador 2 e perdeu do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.tesoura && imagemJogadaComputadorId2==R.mipmap.papel
                && imagemJogadaComputadorId==R.mipmap.pedra){
            resultadoSb.append(" Você Ganhou do Computador 2 e perdeu do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
            /****/
        }else if(jogada==R.mipmap.papel && imagemJogadaComputadorId2==R.mipmap.papel
                &&imagemJogadaComputadorId==R.mipmap.tesoura){
            resultadoSb.append(" Você Empatou do Computador 2 e perdeu do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.pedra && imagemJogadaComputadorId2==R.mipmap.pedra
                && imagemJogadaComputadorId==R.mipmap.papel){
            resultadoSb.append(" Você Empatou com Computador 2 e perdeu do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.tesoura && imagemJogadaComputadorId2==R.mipmap.tesoura
                && imagemJogadaComputadorId==R.mipmap.pedra){
            resultadoSb.append(" Você Empatou com o Computador 2 e perdeu do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
            /****/
        }else if(jogada==R.mipmap.papel && imagemJogadaComputadorId==R.mipmap.papel
                &&imagemJogadaComputadorId2==R.mipmap.pedra){
            resultadoSb.append(" Você Empatou do Computador 1 e Ganhou do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.pedra && imagemJogadaComputadorId==R.mipmap.pedra
                && imagemJogadaComputadorId2==R.mipmap.tesoura){
            resultadoSb.append(" Você Empatou com Computador 1 e Ganhou do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.tesoura && imagemJogadaComputadorId==R.mipmap.tesoura
                && imagemJogadaComputadorId2==R.mipmap.papel){
            resultadoSb.append(" Você Empatou com o Computador 1 e Ganhou do Computador 2 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
            /****/
        } else if(jogada==R.mipmap.papel && imagemJogadaComputadorId2==R.mipmap.papel
                &&imagemJogadaComputadorId==R.mipmap.pedra){
            resultadoSb.append(" Você Empatou do Computador 2 e Ganhou do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.pedra && imagemJogadaComputadorId2==R.mipmap.pedra
                && imagemJogadaComputadorId==R.mipmap.tesoura){
            resultadoSb.append(" Você Empatou com Computador 2 e Ganhou do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());

        }else if(jogada==R.mipmap.tesoura && imagemJogadaComputadorId2==R.mipmap.tesoura
                && imagemJogadaComputadorId==R.mipmap.papel){
            resultadoSb.append(" Você Empatou com o Computador 2 e Ganhou do Computador 1 !");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
            /****/
        }else {
            resultadoSb.append(" Você GANHOU!");
            activityMainBinding.resultadoTv.setText(resultadoSb.toString());
        }
    }
}