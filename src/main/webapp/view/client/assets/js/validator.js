let sign_in = document.querySelector(".req-pass .sign-in-link");
let sign_up = document.querySelector(".req-pass .sign-up-link");

if (sign_in) {
    sign_in.addEventListener("click", function (e) {
        // console.log(this);
        e.preventDefault();
        document.querySelector(".form").classList.remove("form-sign-in");
        document.querySelector(".form").classList.remove("form-sign-up");
        document.querySelector(".form").classList.add("form-sign-in");
        document.querySelector(".breadcrumb li:last-child a").innerText = "Đăng nhập";
    });
}

if (sign_up) {
    sign_up.addEventListener("click", function (e) {
        // console.log(this);
        e.preventDefault();
        document.querySelector(".form").classList.remove("form-sign-in");
        document.querySelector(".form").classList.remove("form-sign-up");
        document.querySelector(".form").classList.add("form-sign-up");
        document.querySelector(".breadcrumb li:last-child a").innerText = "Đăng ký";
    });
}

function Validator(options) {
    var selectorRules = {};

    function validate(inputElement, rule) {
        var errorElement = inputElement.parentElement.querySelector(options.errorSelector);
        var errorMessage;

        // get each rule of selector
        var rules = selectorRules[rule.selector];
        // iterate through each rule & check
        for (var i = 0; i < rules.length; i++) {
            errorMessage = rules[i](inputElement.value);
            if (errorMessage) break;
        }

        if (errorMessage) {
            errorElement.innerText = errorMessage;
            inputElement.parentElement.classList.add("invalid");
        } else {
            errorElement.innerText = "";
            inputElement.parentElement.classList.remove("invalid");
        }
        return !errorMessage;
    }

    var formElement = document.querySelector(options.form);
    if (formElement) {
        formElement.onsubmit = function (e) {
            e.preventDefault();

            var isFormValid = true;
            options.rules.forEach(function (rule) {
                var inputElement = formElement.querySelector(rule.selector);
                var isValid = validate(inputElement, rule);
                if (!isValid) {
                    isFormValid = false;
                }
            });
            if (isFormValid) {
                if (typeof options.onSubmit === "function") {
                    var enableInputs = formElement.querySelectorAll("[name]");
                    var formValues = Array.from(enableInputs).reduce(function (values, input) {
                        values[input.name] = input.value;
                        return values;
                    }, {});
                    options.onSubmit({ formValues });
                } else {
                    formElement.submit();
                }
            }
        };

        options.rules.forEach(function (rule) {
            // save each rule of each selector
            if (!Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector] = [rule.test];
            } else {
                selectorRules[rule.selector].push(rule.test);
            }

            var inputElement = formElement.querySelector(rule.selector);
            if (inputElement) {
                // user blur out
                inputElement.onblur = function () {
                    validate(inputElement, rule);
                };
                // user focus input
                inputElement.oninput = function () {
                    var errorElement = inputElement.parentElement.querySelector(options.errorSelector);
                    errorElement.innerText = "";
                    inputElement.parentElement.classList.remove("invalid");
                };
            }
        });
        // console.log(selectorRules);
    }
}

Validator.isRequired = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined : message || "Vui lòng nhập mục này.";
        },
    };
};

Validator.isPhone = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            for (let i = 0; i < value.length; i++) {
                if (value[i] === " ") return message || "error";
            }
            if (value[0] != 0 || value.length < 10) return message || "error";
            return undefined;
        },
    };
};

Validator.isEmail = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i;
            return regex.test(value) ? undefined : message || "Vui lòng nhập đúng định dạng email.";
        },
    };
};

Validator.minLength = function (selector, min, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.length >= min ? undefined : message || `Vui lòng nhập tối thiểu ${min} ký tự.`;
        },
    };
};

Validator.isConfirmation = function (selector, confirmValue, message) {
    return {
        selector: selector,
        test: function (value) {
            return value === confirmValue() ? undefined : message || "Giá trị nhập lại không khớp. Vui lòng nhập lại!";
        },
    };
};
