PGDMP     ;                
    y            uchet_tekhniki    12.3    12.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16393    uchet_tekhniki    DATABASE     �   CREATE DATABASE uchet_tekhniki WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE uchet_tekhniki;
                postgres    false            �          0    74240    accounts 
   TABLE DATA           �   COPY public.accounts (id, email, telephone, password, last_name, first_name, middle_names, confirmation, confirmation_code, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    204          �          0    74377    spr_counterparty 
   TABLE DATA           �   COPY public.spr_counterparty (id, name, inn, telephone, email, contact, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    218   �       �          0    74256    spr_organization 
   TABLE DATA           k   COPY public.spr_organization (id, name, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    206   m       �          0    74393    doc_income_main 
   TABLE DATA           �   COPY public.doc_income_main (id, executed, data_executed, number_doc, data_doc, sum_con, number_con, data_con, counterparty_id, organization_id, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    220   �       �          0    74319    spr_device_type 
   TABLE DATA           q   COPY public.spr_device_type (id, name, level, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    212          �          0    74336    spr_firm 
   TABLE DATA           j   COPY public.spr_firm (id, name, level, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    214   %!       �          0    74353 	   spr_model 
   TABLE DATA           }   COPY public.spr_model (id, name, firm_id, device_type_id, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    216   l#       �          0    74417    doc_income_sub 
   TABLE DATA           �   COPY public.doc_income_sub (id, model_id, count, parent_id, sum, main_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    222   +       �          0    73822    flyway_schema_history 
   TABLE DATA           �   COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
    public          postgres    false    202   �,       �          0    74272    spr_location 
   TABLE DATA           u   COPY public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    208   �,       �          0    74293 	   spr_users 
   TABLE DATA           �   COPY public.spr_users (id, email, telephone, last_name, first_name, middle_names, location_id, organization_id, global_id, created_at, update_at, deleted_at, deleted) FROM stdin;
    public          postgres    false    210   �.       �          0    74443    registry 
   TABLE DATA              COPY public.registry (id, model_id, inv_number, location_id, user_id, parent_id, global_id, created_at, update_at) FROM stdin;
    public          postgres    false    224   �6       �           0    0    accounts_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.accounts_id_seq', 1, false);
          public          postgres    false    203            �           0    0    doc_income_main_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.doc_income_main_id_seq', 3, true);
          public          postgres    false    219            �           0    0    doc_income_sub_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.doc_income_sub_id_seq', 23, true);
          public          postgres    false    221            �           0    0    registry_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.registry_id_seq', 93, true);
          public          postgres    false    223            �           0    0    spr_counterparty_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.spr_counterparty_id_seq', 1, true);
          public          postgres    false    217            �           0    0    spr_device_type_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.spr_device_type_id_seq', 1, false);
          public          postgres    false    211            �           0    0    spr_firm_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.spr_firm_id_seq', 27, true);
          public          postgres    false    213            �           0    0    spr_location_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.spr_location_id_seq', 1, false);
          public          postgres    false    207            �           0    0    spr_model_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.spr_model_id_seq', 74, true);
          public          postgres    false    215            �           0    0    spr_organization_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.spr_organization_id_seq', 1, false);
          public          postgres    false    205            �           0    0    spr_users_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.spr_users_id_seq', 1, false);
          public          postgres    false    209            �   �   x�}�MJ1@יS���7���R�D�?((�$��N��2�]	^åGЭgHo��݃��$�6o��7���wݺ	�'�9���������v@q�{�s9^�t7�2����x�����<`����d�{��J��y�8���U~�w�q,��Bj���	Lh-x�^g�k5�&� Ǚ�%#T�-W�M�zIe�@�ꉠ&�P0��'R�h�����Hn      �   c   x�}̻�0 �:���l'�v�`�4|�D��@��H�;�(��?�	Q<k����4ϰ%VȻ$��К���q���4�D��Y�D�/���c|�@�      �      x������ � �      �   g   x�U���0�N4�ȿ`;E�
�< T@�n �ew��p��0�M �U�oð��bDi�Wq��)����:�y��5�X��F�$'����;gMc�xޏ��R��o      �     x��X�nE]�����z?zI,���`�,XE�� d+
����I���/T��1���:�:R�(9�9uo�{�V��8��"_7'ͣ� O��*_T�~>ϫf/OG�>��O����V�
~�J�Z�Z;lt2����>�ң�h-�t�{8f3ʿ�>�bY6���� �@n>��� Ɯ�<��<���V��'�F�)Ȭ�#���A3�G�;a�ZQ{Þ>@]5���鐧���vv��K������������T��O��>|�E�5;�Г�2�Es�4'��dl��a�AY�/*^����;t��ΰ��xj0H���9īP ��[tpup�YAj�w<����v�����d��j�Q���~�<Dr�:�p���8��%@��o^���h����<��V0j����!Q�BY,W����F���gtq �Z��Ja���З,`ov���yYyF�s©�L,A,�6.GTd8�1u��9�}��kj���;[�X׳�D���B?��HA�KS����,�Gj��6X�J�B����-������k|��{nCL�p�z��ʔ��F(��+ �-B��
gĢ9�%�� m����(0���
�&t�33�5^|б��6�Ě�q�ž�V�Wh��W�W�7u��
j�yJ�Ak�J��}��X�v��B*�m���SCS=�sϛ�^�(��D�bR�?�K�*��k������)�5ͣ>Y#��I�N7�!��F%g;��X��
��v!�ع�6��[�g���G^����;d�f�K$ZG��V�S&��LB� e'=m��K�՚���U	74����S�0Z��Q�N,-��]��
ʗ���ѧb��^��q�6�:Ѝ?��yJ���G�Kzp�>E�!-ty	bE�&8�t�csEoO�o ���Qs\�
�2��C�׆X
���vì�܂�'{\DHm�7%���K��4*�悛k�O�X�U��Cm��<�}~NV ��k!�#B=�sJ��\��-�r�W� ��[Rn
�W1�h���PbE0�'TqSz�ϋ+=0�Z�O&���iCL����+.��	�RL�����`p�7��]R�T�J/tb�Q��iC,��?��o�5B���8n!�[�� ��)kg�L�羅���/���S`�7�S-�>�N��&����6���Z]����?iC���M����7_�^��X�F�`��J��ѯ�vw V����Ҽ���r����wC���{�ǐ 9m���a� >I����mQ��7T�����h��� �
/      �   7  x����j�0��O�b/`����I��������8��z$�I���a�G�fQ��E�0���|���~F����ί���Q���|@��ʙ$ZIM
=,`3ap�6�yt��99���ܗ�3
�/����^O)�hO��P,�	�\�a�:������p���G��H+y
E)����GW=��&�H��c
E���lL�k�B�B�NA���"m�aw�2#���G�Q����c��Ɯ�]Ve��G����n+?&����Y
uB��9�}"�����b/P�C
��TPtE(�dZ��6�i��f�ǐ0��)���t����
I�2�=�����<r,��C��`v�(*�V�=������a�J�(�����>���Q�h��!�>�N_��a��
#�����(԰,���M]�YCØ6�f���Մ���7ۧz,�(#2�l�쑨�P܎�O�	)Ȍ����YF�X͋�jL���\���7�^~���[5�HgEVr�3��<��2�,W�v��zpwl��<4r��>�_S���]r�����r䗣��>��������.�)	-fS����L& ��
      �   �  x����n��ץ�hhe#�v�K�z7]�PTΈv oHq��`̅��l$b$Ye�U YӁ0�.���
y���<�7�]�������:�ש�5=zZ�/�������Y}U�Z~Q'�������7¥b���ܛy���񱡑g�d4��'���F�F���t�2X2�q�%}�P}r���f��x2�=Mn�X���*��H�����\m�KjH�}4�Mn;�+p�~�S7l\eB��@]R��*xT �� /_!�<c��x5���YndK4ڻ��q,�>`��C9�0T@%� �5��Rc�ԣ�dD�|^�h�Rn��wح��Ϋ�d� ����0�+�+�GF��L�àƳㇳ��W�Z����[Y��/��_�����+�)�*�8oa[�E�KY��DZݞ�
�B*&GO��'���Xק<%hb�]R���t4��~4U^����:4�)%KT����,M��LUP8���J����ڐ�)����������h<��)���s�ؔ�Zo}���Y=8zzz��(���}%3��J>�TK0L�z�u)�u:��y8�մؿ���T:�+h����Rr���w�>�??�?-����_�;�_(� 3(LX"Kk�1�Q_��kΏ�/N�|V�i��q%P@�]Rr��k�'gJ�����"]�@�7�))���������5P����~�.��B�ٚ�^�gs��RB�'wCJְe=�+��eWh��R�E59����X��9��/~�8}2/��1q·�H�y��DBj6�ţŹ��F8�S�ʖ���֠�Kɓ����Y���ZȰ�b
񁇵"��2{�)%s�27&�W� ���)�ZU�Mڂ������?�����SHK�M�Z��q��A=���ᵗ���S��������Yb�E<G���w������x
M��!�]R������r��b+J�ǶKJ,�:���'�Pjm�n�ʺ��:���}�W �%�Ã�$�!�.)�@��!#��֮SJ<؃�	��0��kv��JJ<ԃ��*Y�T:���YI����A��q�Gd�NwJ������֗� Jr�U�+!��,�˂Z�e\+u֥�s]G�摨Ӳ�R��x�K��cryds���;fk%%��R9��\�O���C���	��f���!������%%�ٌ�=����F�!X�v�Ć�xzd3�q9<����۝)���f��J}�T2[Z�}]J8=��t��Hg�M��ץ��#�I�Yg���!c����H��;��Lyn֗7s���Z׎�u)1��h��Tܬ�ɀ
q� ;rz]JP=r�$���<�d���'�
{]J<=r�$�uF�b������AJ��{�4Ŝ��C|�4k�1_+)���i�<r��`Zm]J<=r�B.���k����xz�4��t����6�.%�9�:kxPWJ��m��xz�4KK����b*k�����)���i��8�-���"����6���#��eQ�m�50uJ��G<���!�u����>R���ry�\L&������d�x6Y�]<���4�(���pz����	��b��pz���Á���1�Fg]J8=�9��Ȃ6����nH	�l�x�Z���Q�3]�����OcRB3�m�p�^$�W��?����	h(c	���Fb�jǪ���]��ay�|G������x%-'�U_�q�:Җ,m��ڐ�S���3�����lM�qX���������X�O
">퐻i��e����~�}KJ�!�7c�ʠ�� ������2Vi�����������׊T����hM]R�2�V�/>���.��Prr�+��t��5_B萒1�����Y����\�K�]R�Cu��Aq�V�ׇ�iz��~�Y�ߊ�f��q[�ٕ��vI��!���K[�/��;���?\h.
�_hRedז}�K�)5��7n��?e���      �   ]  x����m!೧�4����T���_B<���F�!���l��� ���!� #�;�o$St��F���V�$��+�����p �S�����"u�[l��1�D�Ga���-"���)�B9��%`����ތ����<{�a��ʑE�{�lpK�p�ƥWY^c��}���;���*�<�r`l�c�X<0�=�a\T�|���^����3d������D�n1�(��˄�}e�5���R���W�fa�+d.{+��&�b��j�'jSA+0�����3��2f6D_&�I]����+,_kIu� .,/�Il0�NU��Y>>��$6Y�����*�?���z����q_�8g      �   X   x�3�4����,���3��q�s8M-,�-͍̍9�KҋR�9��u��B��������X�����Є��؀��+F��� ��(      �   �  x���M��0��r�����%�U��&L)H2��:�����'h(-
s�F�XPl�d��V�<����x9�7�[z�=ߞӟ�'s�ƀ���(݆)t�uܩ�]����>��v���CX�_s� A�R��aE���}��.&�H_����`#*�
����������=]�����1]o�/C��s6�����4�b6���?�_��l�����z'j�����qa)w�����xʒ4Z����i�4X��6ۇ��bиV�[OI����ʣFOנ��8��4xZy��!بA�_J�+O�=���y���4x��Ao� ��R�};-s �y�c* U`h��q0s�1�+P�Ao��Hq)P*0��j�W���S��/P+�h�q�#S���֙�W���|i�T�jg�}g8��\��h�
X���u$<�:�Zl_�s�H:s�1����`�҈���9�*`�4ؾ4��K�8�;� ���j���)�      �   �  x���[o�ǟǟ	P-�3ç�/iQ��S�yYJk� E
�(�zr�6.#�sC`'�%�dȶTӒ)��o�33KΒK����0����?�ը9H�Z��v�0�h�mE㤗���}������tK�-F�p={�M��(��緲���4�d��%XNP�,;�?�����~�:��Ϝ�'�f����1(��_V���[	�r�7�P<��JS��}��@S�E���Np��`��*�$d����k��A����[,N�X���us����I~e?����yO/-���(��(fD29�:I3�	�b({ _��;��GΜ�}���*��B&�C�x4h���v+�u�� q ��'����bj�e�-ԛ�H&�D�e"�q�����x�S�M�;��'�P��5
��+�{���_ �%�e��?���䟛O�w��X�6�4��Ӑ��p���i0݈���c �(g.پ3d�T� ��R�m�YĘ��g�)q�!Ps<�k&�5Q��<7^?�8�I~l3���xT�#���RFo��8����e����
	�͊��͟W��{�m�yJ��b���ukƃ&"Q����
���afvŰ�ͯW�hl�AY$�"�Re��P���uå�}VaȪ��U~��?+����<���ұfA!�>���4��h4���K>��?��	�"ҏE5�����&��d�B�7G�DF�U����"A�:�d/�9�k�Xx&L�m[�o����b�t�3X�!tġӳ
Y������AE�<�S�$�波OV
h�0S�D70�����ve�#��/��v�ӿT5����8�}��|�FȦN�N!"g�I��)�(�R<`r���� �b�C@�e�LS�	��ʙlEj��`V�R�(��P8j����Zꕾ�@Rf���g �3����M�$a<�bA��V�8���[��	�?B��|�0aPN���9�=�h�TvRd���H��i�1��r�,�T����^��
G���7��S;��Y�:���)�����ef��$ꎚi/�H� I+�/��0-/6��+ӎJC�&$�BqPR���#Q��u۰9��� Þ����L�"SH�,�L�1ϊ�c�U4�L�d��jyZ^09㲑�äl���r3�-f���������e��yx0H��5+��g���J����'K`�0S4?��in�$�Z�����Q��g��ƋL{m2�/fy���� �����L��Bt�<�,�E�ɮ�B��1�I�&yb2�FY��T#c&JꒈǑ�1�A+�\ݠvw�N����6A}_�_ye~
&�����.��?)�b�=c��fJ'���lTM��nn���T8��|jz�E��w��Rca#Œ-R+�EE��]q$t�B��v��p�I�A$�i���߶��B�����%)p��qi��@5��A��6^WDZ�ᙀ���N/Y3ur?��*p	K͉n�����gb��9�XW�e@A�s�X�.3�lw��沑��o�0�g������}�tg
Lj�fRUn5 E�H-is�8i�i8>Ϙ2ur*PE���d (F^�AꞜ�j�XJ�"Ÿ� �E!
��ѴƝP������[�6`�߁�9_���o��(�a����)#���fC�� �վ���LP�c�8��u{��L��"�%�R-e�c�ho4�`�rm��Z��f�7?V%xS�(ᤒM%��]�C�-a�������L�3�2�Z����ҿxQ�ƜZt��\Y6���l��؂��l����6^[��i�J
W �y�C.�ݓX����d��!��"���6�7�&Td�b�GV3<�[r,�7e���H��4wF])�5/.|�jΕ�=٩�����,PK�����Oe�U��ő)��M��l2��|� uaG����zem$b^^H]��T�����Ϣk׮���~      �      x������ � �     