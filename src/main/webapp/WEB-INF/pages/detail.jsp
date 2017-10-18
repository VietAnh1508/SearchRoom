<!----details-product-slider--->
<!-- Include the Etalage files -->
<link rel="stylesheet" href="/resources/css/etalage.css">
<script src="/resources/js/jquery.etalage.min.js"></script>
<!-- Include the Etalage files -->
<script>
    jQuery(document).ready(function($){
        $('#etalage').etalage({
            thumb_image_width: 300,
            thumb_image_height: 400,

            show_hint: true,
            click_callback: function(image_anchor, instance_id){
                alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
            }
        });
        // This is for the dropdown list example:
        $('.dropdownlist').change(function(){
            etalage_show( $(this).find('option:selected').attr('class') );
        });

    });
</script>
<!----//details-product-slider--->
<div class="main">
    <div class="shop_top">
        <div class="container">
            <div class="row">
                <div class="col-md-9 single_left">
                    <div class="single_image">
                        <ul id="etalage">
                            <li>
                                <a href="optionallink.html">
                                    <img class="etalage_thumb_image" src="/image/${postDetail.fileName}" />
                                    <img class="etalage_source_image" src="/image/${postDetail.fileName}" />
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- end product_slider -->
                    <div class="single_right">
                        <h3>${postDetail.title}</h3>
                        <p class="m_10">${postDetail.address}</p>
                        <ul class="options">
                            <h4 class="m_12">Area (m<sup>2</sup>)</h4>
                            <p class="m_10">${postDetail.area}</p>
                        </ul>
                        <ul class="add-to-links">
                            <li>Created at: ${postDetail.createdAt}</li>
                            <li>By: ${postDetail.fullName}</li>
                            <li>Email: ${postDetail.email}</li>
                            <li>Phone number: ${postDetail.phoneNumber}</li>
                        </ul>
                    </div>
                    <div class="clear"> </div>
                </div>
                <div class="col-md-3">
                    <div class="box-info-product">
                        <p class="price2">${postDetail.price} VND per month</p>
                        <ul class="prosuct-qty">
                        </ul>
                        <button type="submit" name="Submit" class="exclusive">
                            <span>Save</span>
                        </button>
                    </div>
                </div>
            </div>
            <div class="desc">
                <h4>Description</h4>
                <p>${postDetail.description}</p>
            </div>
            <div class="row">
                <h4 class="m_11">Map</h4>
                <div class="map">
                    <iframe width="100%" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe>
                    <br>
                    <small>
                        <a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265" style="color:#666;text-align:left;font-size:12px"></a>
                    </small>
                </div>
            </div>
        </div>
    </div>
</div>