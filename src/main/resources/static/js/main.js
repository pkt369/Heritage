var slider;
$(window).load(function () {
    slider = new Slider('slider', 3, 2, 1, 20);
    slider.auto();

    $("#slider").mouseenter(function () {
        slider.stop();
    });

    $("#slider").mouseleave(function () {
        slider.auto();
    });
});
var Slider = function (id, _web, _tab, _mobile, spacing) {
    let containerWidth = 0;
    let sliderItemWidth = 0;
    let totalCount = 0;
    let distance = spacing || 10;
    let display = _web;
    let left = 0;
    let interval;

    let DOM = {
        container: function (id) {
            let dom = document.querySelector('#' + id);
            dom.className = 's-container';
            dom.style.position = 'relative';
            dom.style.overflow = 'hidden';
            return dom;
        },
        slider: function (container) {
            totalCount = container.children.length;

            let dom = document.createElement('div');
            dom.className = 'slider'
            dom.style.position = 'relative';
            dom.style.overflow = 'hidden';
            dom.style.height = '100%';
            dom.style.left = 0;
            dom.style.transition = 'left .5s';
            return dom;
        }
    }

    // DOM 만들기
    let container = DOM.container(id);
    let slider = DOM.slider(container);
    let temp = container.innerHTML;
    container.innerHTML = '';
    slider.innerHTML = temp;
    container.appendChild(slider);
    let items = document.querySelector('#' + id + ' .slider').children;
    for (let i = 0; i < items.length; i++) {
        items[i].style.float = 'left';
        items[i].style.height = '100%';
        items[i].style.width = (sliderItemWidth - distance) + 'px';
        items[i].style['margin-right'] = distance + 'px'; // 간격
    }

    // 화면 사이즈 수정시 발생하는 이벤트
    function resize() {
        left = 0;
        document.querySelector('#' + id + ' .slider').style.left = left + 'px';

        let innerWidth = window.innerWidth;
        if (innerWidth >= 1000) {
            setDisplayCount(_web);
        } else if (innerWidth < 1000 && innerWidth >= 768) {
            setDisplayCount(_tab);
        } else if (innerWidth < 768) {
            setDisplayCount(_mobile);
        }

        if (display === 1) {
            distance = 0;
            let items = document.querySelector('#' + id + ' .slider').children;
            for (let i = 0; i < items.length; i++) {
                items[i].style.width = sliderItemWidth + 'px';
                items[i].style['margin-right'] = 0 + 'px'; // 간격
            }
        }
    }

    // 디스플레이 갯수 설정 함수
    function setDisplayCount(count) {
        display = count;

        containerWidth = container.offsetWidth + distance;
        sliderItemWidth = containerWidth / display;

        document.querySelector('#' + id + ' .slider').style.width = totalCount * sliderItemWidth + distance * totalCount + 'px';
        let items = document.querySelector('#' + id + ' .slider').children;
        for (let i = 0; i < items.length; i++) {
            items[i].style.width = (sliderItemWidth - distance) + 'px';
        }
    }

    // 반응형 디스플레이 갯수 조절
    if (_tab !== undefined && _mobile !== undefined) {
        window.onresize = resize;
    }
    resize();


    return {
        setDisplayCount: setDisplayCount,
        move: function (index) {
            left = (-1) * sliderItemWidth * index;
            document.querySelector('#' + id + ' .slider').style.left = left + 'px';
        },
        prev: function () {
            left += sliderItemWidth;
            let limit = 0;
            if (left > limit) {
                left = limit;
            }
            document.querySelector('#' + id + ' .slider').style.left = left + 'px';
        },
        next: function () {
            left -= sliderItemWidth;
            let limit = (-1) * sliderItemWidth * (totalCount - display);
            if (left < limit) {
                left = limit;
            }
            document.querySelector('#' + id + ' .slider').style.left = left + 'px';
        },
        auto: function () {
            clearInterval(interval);
            interval = setInterval(function () {
                left -= sliderItemWidth;
                let limit = (-1) * sliderItemWidth * (totalCount - display);
                if (left < limit) {
                    left = 0;
                }
                document.querySelector('#' + id + ' .slider').style.left = left + 'px';
            }, 3000)
        },
        stop: function () {
            clearInterval(interval);
        }
    }
}

var slideIndex = 0; //slide index

// HTML 로드가 끝난 후 동작
window.onload=function(){
  showSlides(slideIndex);

  // Auto Move Slide
  var sec = 4000;
  setInterval(function(){
    slideIndex++;
    showSlides(slideIndex);

  }, sec);
}


// Next/previous controls
function moveSlides(n) {
  slideIndex = slideIndex + n
  showSlides(slideIndex);
}

// Thumbnail image controls
function currentSlide(n) {
  slideIndex = n;
  showSlides(slideIndex);
}

function showSlides(n) {

  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  var size = slides.length;

  if ((n+1) > size) {
    slideIndex = 0; n = 0;
  }else if (n < 0) {
    slideIndex = (size-1);
    n = (size-1);
  }

  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }

  slides[n].style.display = "block";
  dots[n].className += " active";
}
