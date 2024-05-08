import globals from "globals";
import pluginJs from "@eslint/js";
import pluginReactConfig from "eslint-plugin-react/configs/recommended.js";
import eslintConfigPrettier from "eslint-config-prettier";


export default [
  pluginJs.configs.recommended,
  pluginReactConfig,
  eslintConfigPrettier,
  {
    languageOptions: { 
      globals: globals.browser 
    },
    files: ['src/**/*.{js,jsx}',],
    settings: {
      react: {
        "version": "detect"
      }
    },
    rules: {
      "react/react-in-jsx-scope": "off"
    }
  },
];