package com.templateonetwo.testingtemplateonetwo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.media.ThumbnailUtils.extractThumbnail;

public class Fragment4_B1 extends android.support.v4.app.Fragment implements Fragment1.OnVideoSelectedLister, Fragment1.OnPhotoSelectedLister, AdapterView.OnItemSelectedListener {



    private static final String Tag = "Fragment4_B1";
    private Button btnNavFrag4b;
    static final int REQUEST_VIDEO_CAPTURE = 103;
   static final int REQUEST_IMAGE_CAPTURE = 104;
    public VideoView result_video;
    public Button mPlayButton;
    public ImageView bitmapthumbnail;
    public ImageView secondimage;

    public Intent videopath;
    private Uri mImageUri;
    private Bitmap mBitmap;
    private Spinner mSpinner;

    String[] CategoryNames={"General Fix", "Appliances","Brick, Concrete, & Stone", "Cleaning", "Drywall",
            "Electric", "Flooring", "Garage", "Junk Removal", "Kitchen",
            "Heating & Cooling", "Lawn & Yard work", "Painting",
            "Plumbing & Bathroom", "Remodeling", "Roofing & Gutters", "Siding",
            "Windows", "Other" };

    /*below is auto-generate code from right clicking and inserting 'OnCreateView', this method
    is specific to Fragments vs. 'OnCreate' which is just for activities.
    You also have to create View objects and return at the bottom of onCreateView
     Deleted the 'super return...' code line */



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment4_b1_layout_video_path, container, false);

        btnNavFrag4b = (Button) view.findViewById(R.id.btnNavFrag4b1);
        mPlayButton = (Button) view.findViewById(R.id.btnReplay);
        result_video = (VideoView) view.findViewById(R.id.videoView2);
    //  bitmapthumbnail = (ImageView) view.findViewById(R.id.bmThumbnail);
        secondimage = (ImageView) view.findViewById(R.id.imageView2);

        Fragment1.OnPhotoSelectedLister onPhotoSelectedLister = (Fragment1.OnPhotoSelectedLister) getActivity();
        final Fragment1.OnVideoSelectedLister onVideoSelectedLister = (Fragment1.OnVideoSelectedLister) getActivity();

        if (onVideoSelectedLister.getVideopath() == null)
            //  bitmapthumbnail.setImageBitmap(onPhotoSelectedLister.setImageBitmap());
            secondimage.setImageBitmap(onPhotoSelectedLister.setImageBitmap());


        else  {
            Uri Viduri = onVideoSelectedLister.getVideopath();
            //     String [] filePathColumn = {MediaStore.Images.Media.DATA};
            //String path=uri.getPath(); so this was removed
            //     Cursor cursor = getActivity().getContentResolver().query(uri, filePathColumn, null, null, null);
            //     cursor.moveToFirst();
            //     int columnIndex = cursor.getColumnIndex(filePathColumn [0]);
            //    String picturePath = cursor.getString(columnIndex);
            //    cursor.close();

            result_video.setVideoURI(Viduri);

        }

        Log.d(Tag, "onCreateView: started.");

        /////All new code for media upload ////////////////////

        //  else if (onVideoSelectedLister.getVideopath()==null && onPhotoSelectedLister.getImageBitmap() ==null);
        // { secondimage.setImageBitmap(onPhotoSelectedLister.setImagePath());   }

        // Bitmap bitmap2 = ThumbnailUtils.createVideoThumbnail(picturePath, MediaStore.Images.Thumbnails.FULL_SCREEN_KIND);
        //bitmapthumbnail.setImageBitmap(bitmap2);


        //Above is Vipul's code after 'bitmapthumbnail..else{..', he used something called cursor to retrieve 'Data'//


        //*attempt to playback newly captured Video with an onclick listener*/
        //     bitmapthumbnail.setOnClickListener(new View.OnClickListener() {
        //      @Override
        //    public void onClick(View v) {

                /*bitmapthumbnail.(); Use video view and image view, then setup a condition to use image view
                layer on top of video view and set to invisible...or something of the like */

        result_video.setOnClickListener(new View.OnClickListener() {   /*you can replace result_video with mPlaybutton*/

            @Override
            public void onClick(View v) {

                result_video.start();
                secondimage.setVisibility(View.INVISIBLE);

            }
        });


        //Getting the instance of Spinner and applying OnItemSelectedListener on it

        mSpinner = (Spinner) view.findViewById(R.id.spinner2);
        mSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, CategoryNames);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mSpinner.setAdapter(LTRadapter);


            /*For fragments, contextually, you are "in" an activity already, so you don't traditionally
              navigate to other 'activities', you have to 'getActivity'as seen below*/


        //* button 4b placeholder *//
        btnNavFrag4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 4B2", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).setViewPager(5);
            }

        });

        return view;


    }





/*Needed for this class to implement spinner class methods in order to work*/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }



    public void setBitmapthumbnail(ImageView bitmapthumbnail) {
        this.bitmapthumbnail = bitmapthumbnail;

    }
/*configuration for camcorder setup 2, this code is if camera activity will happen on same screen, so am temporarily disabling
      as we need the code from Fragement 1 which is where camera activity is located */
  /*  @Override
    public void onActivityResult (int requestCode, int resultCode, Intent getVideopath){
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = getVideopath.getData(); /*this '.getData' function is just going to fetch where the data was stored*/
//            result_video.setVideoURI(videoUri);
//            Intent videoIntent = getVideopath;


        /*configuration for camcorder setup */
        /*configuration for camcorder setup 2, this code is if camera activity will happen on same screen, so am temporarily disabling
      as we need the code from Fragement 1 which is where camera activity is located */
//        mPlayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//            }
//        });
//    }




    @Override
        public void getImagePath(Uri imagePath) {
            Log.d(Tag, "setting image to imageview bitmapthumbnail");

            secondimage.setImageURI(imagePath);
            mBitmap = null;
            mImageUri = imagePath;
            // setTargetFragment(this, 104);

        }



    @Override
    public void getImageBitmap(Bitmap bitmap) {
        Log.d(Tag, "setting image from gallery to bitmapthumbnail");

       secondimage.setImageBitmap(bitmap);
       mImageUri = null;
       mBitmap = bitmap;


    }

    @Override
    public Uri setImagePath() {
        return null;
    }

    @Override
    public Bitmap setImageBitmap() {
        return null;
    }


    @Override
    public Uri getVideopath() {
        return null;
    }

    @Override
    public void setVideopath(Uri data) {

    }







}



/* extra junk code to test/play with*/
// Bitmap bmThumbnail = createVideoThumbnail(String.valueOf(getVideopath()), MediaStore.Images.Thumbnails.MINI_KIND);
        /*   viewImage.setImageBitmap(bmThumbnail); */

