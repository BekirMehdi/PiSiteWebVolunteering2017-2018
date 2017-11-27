package com.example.dell_pc.volunteering;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import android.text.TextUtils;

import android.view.WindowManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class AddEventActivity extends AppCompatActivity {
    private String mJSONURLString = "http://10.0.2.2:18080/volunteering-web/rest/Event";



      EditText ed_nameEvent ;
      EditText ed_typeEvent ;
      EditText ed_address ;
      EditText ed_phone ;
      EditText ed_description ;

     private TextInputLayout inputLayoutName, inputLayoutType, inputLayoutAddress,inputLayoutPhone,inputLayoutDescription;
    ImageView image;
    Button choose;
    int PICK_IMAGE_REQUEST = 111;
    Bitmap bitmap;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutType = (TextInputLayout) findViewById(R.id.input_layout_type);
        inputLayoutAddress = (TextInputLayout) findViewById(R.id.input_layout_address);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.input_layout_phone);
        inputLayoutDescription = (TextInputLayout) findViewById(R.id.input_layout_description);
        ed_nameEvent = (EditText) findViewById(R.id.et_nameEvent);
        ed_typeEvent = (EditText) findViewById(R.id.et_typeEvent);
        ed_address = (EditText) findViewById(R.id.et_address);
        ed_phone = (EditText) findViewById(R.id.et_phone);
        ed_description = (EditText) findViewById(R.id.et_description);
        final Button addEvent = findViewById(R.id.btn_addEvent);


        ed_nameEvent.addTextChangedListener(new MyTextWatcher(ed_nameEvent));
        ed_typeEvent.addTextChangedListener(new MyTextWatcher(ed_typeEvent));
        ed_address.addTextChangedListener(new MyTextWatcher(ed_address));
        ed_phone.addTextChangedListener(new MyTextWatcher(ed_phone));
        ed_description.addTextChangedListener(new MyTextWatcher(ed_description));

        image = (ImageView)findViewById(R.id.image);
        choose = (Button)findViewById(R.id.choose);


        //opening image chooser option
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
            }
        });



        //________________________________________________________________________________________________


        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                if (!validateName()) {
                    return;
                }

                if (!validateType()) {
                    return;
                }

                if (!validatePhone()) {
                    return;
                }
                if (!validateAddress()) {
                    return;
                }

                Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
                //______________________________________validate__________________________________________________________
                progressDialog = new ProgressDialog(AddEventActivity.this);
                progressDialog.setMessage("Uploading, please wait...");
                progressDialog.show();

                //converting image to base64 string
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] imageBytes = baos.toByteArray();
                final String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);



        Map<String,String> params = new HashMap<>();
        params.put("nameEvent",ed_nameEvent.getText().toString());
        params.put("typeEvent",ed_typeEvent.getText().toString());
        params.put("typeEvent","115.857342");
        params.put("latitude","-31.952854");
        params.put("longitude",ed_nameEvent.getText().toString());
        params.put("typeEvent",ed_typeEvent.getText().toString());
        params.put("typeEvent",ed_description.getText().toString());
                params.put("imgPath", imageString);

        JsonObjectRequest jsonRequest = new JsonObjectRequest (Request.Method.POST, mJSONURLString,new JSONObject(params),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {


                        Context context = getApplicationContext();
                        CharSequence text ="ajout reussite ,";

                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Context context = getApplicationContext();


                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, error.getMessage(), duration);
                        toast.show();
                    }
                })

        {

            @Override
            public Map<String, String> getHeaders()  {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(AddEventActivity.this);
        requestQueue.add(jsonRequest);

              //  Intent intent = new Intent(AddEventActivity.this, MainActivity.class);

                //startActivity(intent);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {
                //getting image from gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
                image.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Validating form
     */


    private boolean validateName() {
        if (ed_nameEvent.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(ed_nameEvent);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateType() {
        if (ed_typeEvent.getText().toString().trim().isEmpty()) {
            inputLayoutType.setError(getString(R.string.err_msg_type));
            requestFocus(ed_typeEvent);
            return false;
        } else {
            inputLayoutType.setErrorEnabled(false);
        }

        return true;
    }



    private boolean validateAddress() {
        String email = ed_address.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutAddress.setError(getString(R.string.err_msg_address));
            requestFocus(ed_address);
            return false;
        } else {
            inputLayoutAddress.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhone() {
        if (ed_phone.getText().toString().trim().isEmpty()) {
            inputLayoutPhone.setError(getString(R.string.err_msg_phone));
            requestFocus(ed_phone);
            return false;
        } else {
            inputLayoutPhone.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDescription() {
        String email = ed_description.getText().toString().trim();

        if (ed_description.getText().toString().trim().isEmpty()) {
            inputLayoutDescription.setError(getString(R.string.err_msg_description));
            requestFocus(ed_description);
            return false;
        } else {
            inputLayoutDescription.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.et_nameEvent:
                    validateName();
                    break;
                case R.id.et_typeEvent:
                    validateType();
                    break;
                case R.id.et_address:
                    validatePhone();
                    break;

                case R.id.et_phone:
                    validateAddress();
                    break;

            }
        }
    }

}
