package appocorrencias.com.appocorrencias.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import appocorrencias.com.appocorrencias.R;


public class PerfilFragment extends Fragment{

    private CriarReferencia referencia;
    private Button btnCriarOcorrencia;


    private static final String PREF_NAME = "MainActivityPreferences";

    public PerfilFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        btnCriarOcorrencia = (Button) view.findViewById(R.id.btnCadastrarOcorrencias);

        btnCriarOcorrencia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Chama aqui o método da activity
                referencia.onCreateOcorrencia();
            }
        });




        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Bundle bundle = getArguments();
        if(bundle!=null){
            String nomecompleto = bundle.getString("nomecompleto");
            Log.i("SCRIPT frgagment",nomecompleto);
        }


//        String nomecompleto="Não funciona";
//        if (bundle != null) {
//            nomecompleto = bundle.getString("nomecompleto");
//            System.out.println("Teste" +nomecompleto+ " funcionou");
//
//        }
//        Log.i("RESULTADO",nomecompleto);
//        //nomecompleto = bundle.getString("nomecompleto");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            referencia =(CriarReferencia) activity;

        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+"Deve Implementar a CriarReferencia");
        }
    }

    public interface CriarReferencia{

        public void onCreateOcorrencia();

    }
}
